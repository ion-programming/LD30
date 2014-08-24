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
		if(x <= destx - img.getWidth()){
			Update.clouds.remove(this);
			return true;
		}
		return false;
	}
}
