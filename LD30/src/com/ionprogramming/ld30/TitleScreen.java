package com.ionprogramming.ld30;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.ionprogramming.ld30.cloudgen.Cloud;
import com.ionprogramming.ld30.cloudgen.Generate;

public class TitleScreen {

	static BufferedImage[] ion;
	static TitlePixel[] ionTP;
	static int ionCol = 86;
	static int ionRow = 32;
	static BufferedImage[] ld;
	static TitlePixel[] ldTP;
	static int ldCol = 80;
	static int ldRow = 12;
	static Random r;
	
	static int stage = 99;
	static int iCount = 0;
	
	
	public static void load(){
		r = new Random();
		ion = ImageHandler.splitImage(Images.ion, ionCol, ionRow, 0);
		ionTP = new TitlePixel[ion.length];
		ld = ImageHandler.splitImage(Images.ld, ldCol, ldRow, 0);
		ldTP = new TitlePixel[ld.length];
		
		//initialise array of Title Pixels
		for(int i = 0; i < ion.length; i++){
			ionTP[i] = new TitlePixel((i % ionCol) * Images.ion.getWidth() / ionCol + ((LD30.width / 2) - (Images.ion.getWidth()/2)), LD30.height, (int)(i/ionCol)*(Images.ion.getHeight() / ionRow) + ((LD30.height / 2) - (Images.ion.getHeight()/2)), ion[i], r.nextInt(40)+15);
		}
		
		for(int i = 0; i < ld.length; i++){
			ldTP[i] = new TitlePixel((i % ldCol) * Images.ld.getWidth() / ldCol + ((LD30.width / 2) - (Images.ld.getWidth()/2)), LD30.height, (int)(i/ldCol)*(Images.ld.getHeight() / ldRow) + ((LD30.height / 2) - (Images.ld.getHeight()/2)), ld[i], r.nextInt(40)+15);
		}
	}
	
	public static void render(Graphics g){
		if(stage == 99){
			iCount++;
			if(iCount >= 20){
				stage = 0;
			}
		}
		else if(stage == 0){
			for(int i = 0; i < ionTP.length; i++){
				ionTP[i].draw(g);
			}
			boolean a = true;
			for(int i = 0; i < ionTP.length; i++){
				if(ionTP[i].done == false){
					a = false;
					break;
				}
			}
			if(a){
				stage = 1;
			}
		}
		else if(stage == 1){
			for(int i = 0; i < ldTP.length; i++){
				ldTP[i].draw(g);
			}
			boolean a = true;
			for(int i = 0; i < ldTP.length; i++){
				if(ldTP[i].done == false){
					a = false;
					break;
				}
			}
			if(a){
				Window.game.setBackground(new Color(0x2D85FF));
				for(int c = 0; c < Update.numCloud; c++){
					Update.clouds.add(new Cloud(Generate.gen(), r.nextInt(1600)-400, r.nextInt(300)-150, 0, r.nextDouble() + 0.2));
				}
				LD30.titleScreen = false;
			}
		}

	}
	
}

class TitlePixel{
	
	int x;
	int y;
	int speed;
	int desty;
	BufferedImage img;
	int countB = 0;
	boolean done  = false;
	
	public TitlePixel(int x, int y, int desty, BufferedImage img, int speed){
		this.x = x;
		this.y = y;
		this.desty = desty;
		this.img = img;
		this.speed = speed;
	}
	
	public void draw(Graphics g){
		g.drawImage(img, x, y, null);
		y -= speed;
		if(countB <= 100){
			if(y <= desty){
				y = desty;
				countB ++;
			}
		}
		else{
			if(y <= -50){
				done = true;
				y = -50;
			}
		}
	}
	
}
