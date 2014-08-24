package com.ionprogramming.ld30.cloudgen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ionprogramming.ld30.Update;

public class Cloud {

	BufferedImage img;
	double x;
	int y;
	int destx;
	double speed;
	public static boolean left;
	public static boolean right;
	
	public Cloud(BufferedImage img, double x, int y, int destx, double speed){
		this.img = img;
		this.x = x;
		this.y = y;
		this.destx = destx;
		this.speed = speed;
	}
	
	public boolean draw(Graphics g){
		g.drawImage(img, (int) x, y, null);
		
		x-=speed;
		if(left){
			x+= 0.5*speed;
		}
		else if(right){
			x-= 0.5*speed;
		}
		
		if(x <= destx - img.getWidth()){
			Update.clouds.remove(this);
			return true;
		}
		return false;
	}
}
