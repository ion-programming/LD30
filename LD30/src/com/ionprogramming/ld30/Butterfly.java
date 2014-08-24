package com.ionprogramming.ld30;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Butterfly {
	
	static Random r = new Random();
	public final double RANGE = 30;
	public final double speed = 2;
	public double initx;
	public double inity;
	public double x;
	public double y;
	public double xvel = 0;
	public double yvel = 0;
	public BufferedImage bf1, bf2;
	int timer = 0;
	
	public Butterfly(double x, double y){
		this.x = x;
		this.y = y;
		initx = x;
		inity = y;
		int c1 = r.nextInt(0xFFFFFF);
		int c2 = r.nextInt(0xFFFFFF);
		int c3 = r.nextInt(0xFFFFFF);
		bf1 = ImageHandler.replaceColor(ImageHandler.replaceColor(ImageHandler.replaceColor(ImageHandler.replaceColor(Images.bf1, 0xFFFFFF, c1), 0x808080, c2), 0x000000, c3), 0xFF00FF, 0x00FFFFFF);
		bf2 = ImageHandler.replaceColor(ImageHandler.replaceColor(ImageHandler.replaceColor(ImageHandler.replaceColor(Images.bf2, 0xFFFFFF, c1), 0x808080, c2), 0x000000, c3), 0xFF00FF, 0x00FFFFFF);
	}
	
	public void draw(Graphics g){
		if(x - Map.playerX > -7 && x - Map.playerX < LD30.width && y - Map.playerY > -7 && y - Map.playerY < LD30.height){
			if(r.nextInt(50) == 0){
				xvel = (r.nextDouble() - 0.5)*speed;
			}
			if(r.nextInt(50) == 0){
				yvel = (r.nextDouble() - 0.5)*speed;
			}
			x+= xvel;
			y+= yvel;
			if(x > initx + RANGE){
				x = initx + RANGE;
			}
			else if(x < initx - RANGE){
				x = initx - RANGE;
			}
			if(y > inity + RANGE){
				y = inity + RANGE;
			}
			else if(y < inity - RANGE){
				y = inity - RANGE;
			}
			if(timer < 5){
				g.drawImage(bf1, (int) x - Map.playerX, (int) y - Map.playerY, null);
			}
			else if(timer < 10){
				g.drawImage(bf2, (int) x - Map.playerX, (int) y - Map.playerY, null);
			}
			else{
				timer = -1;
			}
			timer++;
		}
	}
}
