package com.ionprogramming.atomic2d.blocks;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import com.ionprogramming.atomic2d.collisionbodies.CollisionBody;
import com.ionprogramming.atomic2d.graphics.ImageHandler;
import com.ionprogramming.atomic2d.graphics.RotBufferedImage;

public class Block {
	
	public CollisionBody collisionBody;
	private BufferedImage[] imagesSource;
	private RotBufferedImage[] images;
	private int imageNum = 0;
	private float xpos = 0;
	private float ypos = 0;
	private int width = 1;
	private int height = 1;
	private float xc = 0;
	private float yc = 0;
	private float xOffset = 0;
	private float yOffset = 0;
	
	public void draw(Graphics g, float w, float h){
		if((int) (xpos + xOffset) > -width || (int) (xpos + xOffset) < w){
			if((int) (ypos + yOffset) > -height || (int) (ypos + yOffset) < h){
				images[imageNum].draw(g, (int) (xpos + xOffset), (int) (ypos + yOffset));
			}
		}
	}
	
	public float getXOffset(){
		return xOffset;
	}
	
	public float getYOffset(){
		return yOffset;
	}
	
	public void setXOffset(float x){
		xOffset = x;
	}
	
	public void setYOffset(float y){
		yOffset = y;
	}
	
	public Point2D.Float getOffset(){
		return new Point2D.Float(xOffset, yOffset);
	}
	
	public void setOffset(float x, float y){
		xOffset = x;
		yOffset = y;
	}
	
	public float getXCentre(){
		return xc;
	}
	
	public void setXCentre(float x){
		xc = x;
	}
	
	public float getYCentre(){
		return yc;
	}
	
	public void setYCentre(float y){
		yc = y;
	}
	
	public void setCentre(float x, float y){
		xc = x;
		yc = y;
	}
	
	public void setCentre(Point2D.Float p){
		xc = p.x;
		yc = p.y;
	}
	
	public Point2D.Float getCentre(){
		return new Point2D.Float(xc, yc);
	}

	public void setLoc(float x, float y){
		xpos = x;
		ypos = y;
	}
	
	public void setX(float x){
		xpos = x;
	}
	
	public void setY(float y){
		ypos = y;
	}
	
	public float getX(){
		return xpos;
	}
	
	public float getY(){
		return ypos;
	}
	
	public void setCurrentImage(int index){
		imageNum = index;
	}
	
	public int getCurrentImage(){
		return imageNum;
	}
	
	public void setImages(BufferedImage[] imgs){
		imagesSource = imgs;
		images = new RotBufferedImage[imagesSource.length];
		for(int n = 0; n < imagesSource.length; n++){
			images[n] = ImageHandler.resizeImageRot(imagesSource[n], width, height);
		}
	}
	
	public BufferedImage[] getImages(){
		return imagesSource;
	}
	
	public void setImage(BufferedImage img, int index){
		imagesSource[index] = img;
		images[index] = ImageHandler.resizeImageRot(imagesSource[index], width, height);
	}
	
	public BufferedImage getImage(int index){
		return imagesSource[index];
	}
	
	public void setWidth(int newW){
		width = newW;
		for(int n = 0; n < imagesSource.length; n++){
			images[n] = ImageHandler.resizeImageRot(imagesSource[n], width, height);
		}
	}
	
	public void setHeight(int newH){
		height = newH;
		for(int n = 0; n < imagesSource.length; n++){
			images[n] = ImageHandler.resizeImageRot(imagesSource[n], width, height);
		}
	}
	
	public float getWidth(){
		return width;
	}
	
	public float getHeight(){
		return height;
	}
	
	public Point2D.Float getSize(){
		return new Point2D.Float(width, height);
	}
	
	public void resize(int newW, int newH){
		width = newW;
		height = newH;
		for(int n = 0; n < imagesSource.length; n++){
			images[n] = ImageHandler.resizeImageRot(imagesSource[n], width, height);
		}
	}
	
	public void setToCollisionStats(){
		setLoc(collisionBody.getX() - xc, collisionBody.getY() - yc);
	}
	
	public void setCollisionStats(){
		collisionBody.setCentre(getX() + xc, getY() + yc);
	}
	
	public void setRotation(float r, float xa, float ya){
		for(int n = 0; n < imagesSource.length; n++){
			images[n] = ImageHandler.rotateImage(ImageHandler.resizeImage(imagesSource[n], (int) getWidth(), (int) getHeight()), r, xa, ya);
		}
	}
}
