package com.ionprogramming.atomic2d.graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;

public class ImageHandler {
	
	public static BufferedImage[] splitImage(BufferedImage pictures, int columns, int rows, int lineWidth){
		int imgW = (pictures.getWidth()-(columns-1)*lineWidth)/columns;
		int imgH = (pictures.getHeight()-(rows-1)*lineWidth)/rows;
		int imgNum = 0;
		BufferedImage[] pics = new BufferedImage[columns*rows];		
		for(int y=0; y < rows; y++){
			for(int x=0; x < columns; x++){
				pics[imgNum] = new BufferedImage(imgW, imgH, pictures.getType());	
				Graphics2D g = pics[imgNum].createGraphics();  
                g.drawImage(pictures, 0, 0, imgW, imgH, imgW*x+x*lineWidth, imgH*y+y*lineWidth, imgW*x+imgW+x*lineWidth, imgH*y+imgH+y*lineWidth, null);  
                g.dispose(); 
	            imgNum++;  
			}
		}	
		return pics;
	}
	
	public static BufferedImage resizeImage(BufferedImage img, int newW, int newH) {  
        int w = img.getWidth();  
        int h = img.getHeight();  
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
        Graphics2D g = dimg.createGraphics();  
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
        g.dispose();  
        return dimg;  
    }
	
	public static RotBufferedImage resizeImageRot(BufferedImage img, int newW, int newH) {  
        int w = img.getWidth();  
        int h = img.getHeight();  
        RotBufferedImage dimg = new RotBufferedImage(newW, newH, img.getType(), 0);  
        Graphics2D g = dimg.createGraphics();  
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
        g.dispose();  
        return dimg;  
    }
	
	public static RotBufferedImage rotateImage(BufferedImage img, float angle){
		return rotateImage(img, angle, img.getWidth()/2, img.getHeight()/2);
	}
	
	public static RotBufferedImage rotateImage(BufferedImage img, float angle, float anchorx, float anchory){
		AffineTransform t = new AffineTransform();
		t.rotate(angle, anchorx, anchory);
		int[] x = new int[4];
		int[] y = new int[4];
		Point2D.Double p = (Double) t.deltaTransform(new Point2D.Double(-img.getWidth()/2, -img.getHeight()/2), null);
		x[0] = (int) p.x;
		y[0] = (int) p.y;
		p = (Double) t.deltaTransform(new Point2D.Double(img.getWidth()/2, -img.getHeight()/2), null);
		x[1] = (int) p.x;
		y[1] = (int) p.y;
		p = (Double) t.deltaTransform(new Point2D.Double(img.getWidth()/2, img.getHeight()/2), null);
		x[2] = (int) p.x;
		y[2] = (int) p.y;
		p = (Double) t.deltaTransform(new Point2D.Double(-img.getWidth()/2, img.getHeight()/2), null);
		x[3] = (int) p.x;
		y[3] = (int) p.y;
		int minx = x[0];
		int maxx = x[0];
		int miny = y[0];
		int maxy = y[0];
		for(int n = 1; n < x.length; n++){
			if(x[n] < minx){
				minx = x[n];
			}
			else if(x[n] > maxx){
				maxx = x[n];
			}
			if(y[n] < miny){
				miny = y[n];
			}
			else if(y[n] > maxy){
				maxy = y[n];
			}
		}
		Point2D.Double ap = (Double) t.deltaTransform(new Point2D.Double(img.getWidth()/2 - anchorx, img.getHeight()/2 - anchory), null);
		t.setToTranslation(-minx - anchorx - ap.x, -miny - anchory - ap.y);
		t.rotate(angle, anchorx, anchory);
		RotBufferedImage result = new RotBufferedImage(maxx - minx, maxy - miny, img.getType(), angle);
		Graphics2D g = result.createGraphics();
		g.drawImage(img, t, null);
		g.dispose();
		result.setOffset((int) (minx + anchorx + ap.x), (int) (miny + anchory + ap.y));
		return result;
	}
}
