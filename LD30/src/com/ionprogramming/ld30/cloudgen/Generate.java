package com.ionprogramming.ld30.cloudgen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.util.Random;

public class Generate {
	
	static Random random = new Random();
	static int width = 300;
	static int height = 150;
	static int particleW = 50;
	static int particleH = 20;
	static boolean particleR = false;
	static double innerP = 0.02f;
	static double outerP = -0.001f;
	static int red = 255;
	static int green = 255;
	static int blue = 255;
	static int alpha = 40;
	static int alphaCut = 101;
	static int blur = 2;
	static int blurIt = 3;

	public static BufferedImage gen(){
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics2D g = img.createGraphics();
		g.setColor(new Color(red, green, blue, alpha));
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				double d = Math.sqrt((y - height/2)*(y - height/2) + (x - width/2)*(x - width/2));
				double a = Math.atan((double)(y - height/2)/(x - width/2));
				double maxd = (width*height/2)/Math.sqrt((height*Math.cos(a))*(height*Math.cos(a)) + (width*Math.sin(a))*(width*Math.sin(a)));
				double p = outerP + ((maxd - d)/maxd)*(innerP - outerP);
				if(random.nextDouble() < p){
					if(particleR){
						int pW = random.nextInt(particleW);
						int pH = random.nextInt(particleH);
						g.fillOval(x - pW/2, y - pH/2, pW, pH);
					}
					else{
						g.fillOval(x - particleW/2, y - particleH/2, particleW, particleH);
					}
				}
			}
		}
		Raster r = img.getData();
		DataBufferInt data = (DataBufferInt)r.getDataBuffer();
		int[] pixels = data.getData();
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				int a = 0xFF & (pixels[y*width + x]>>24);
				if(a < alphaCut){
					pixels[y*width + x] = 0;
				}
			}
		}
		BoxBlurFilter filter = new BoxBlurFilter();
		filter.setRadius(blur);
		filter.setIterations(blurIt);
		pixels = filter.filter(pixels, width);
		final int[] a = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
		System.arraycopy(pixels, 0, a, 0, pixels.length);
		return img;
	}
	
	public static int getColor(int a, int r, int g, int b){
		return (255<<24)|(255<<16)|(255<<8)|255;
	}
}
