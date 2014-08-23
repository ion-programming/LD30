package com.ionprogramming.atomic2d.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class RotBufferedImage extends BufferedImage {

	private int x = 0;
	private int y = 0;
	private float rot = 0;
	
	public RotBufferedImage(int width, int height, int imageType, float r) {
		super(width, height, imageType);
		rot = r;
	}
	
	public void draw(Graphics g, int xpos, int ypos){
		g.drawImage(this, x + xpos, y + ypos, null);
	}
	
	public void draw(Graphics g, int xpos, int ypos, ImageObserver ob){
		g.drawImage(this, x + xpos, y + ypos, ob);
	}
	
	public void drawNoOffset(Graphics g, int xpos, int ypos){
		g.drawImage(this, x, y, null);
	}
	
	public void drawNoOffset(Graphics g, int xpos, int ypos, ImageObserver ob){
		g.drawImage(this, x, y, ob);
	}
	
	public void setXOffset(int newx){
		x = newx;
	}
	
	public int getXOffset(){
		return x;
	}
	
	public void setYOffset(int newy){
		y = newy;
	}
	
	public int getYOffset(){
		return y;
	}
	
	public void setOffset(int newx, int newy){
		x = newx;
		y = newy;
	}
	
	public float getRot(){
		return rot;
	}
}
