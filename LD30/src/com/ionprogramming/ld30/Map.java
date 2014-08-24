package com.ionprogramming.ld30;

import java.awt.Graphics;

public class Map {
	public static final int MAXHEIGHTRANGE = 200;
	public static final int XFREERANGE = 200;
	public static int playerX = 0;
	public static int playerXFree = XFREERANGE/2;
	public static int playerY = 0;
	public static int playerimg = 0;
	public static boolean left = false;
	
	public static void draw(Graphics g){
		int y = 0;
		while(y < Images.map1.getHeight() && Images.map1.getRGB(playerX + playerXFree + (Window.game.getWidth() - XFREERANGE)/2, y) == 0x00FFFFFF){
			y++;
		}

		playerY = y;
		g.drawImage(Images.map1, -playerX, -playerY - MAXHEIGHTRANGE, null);
		if(left){
			g.drawImage(Images.player[playerimg+4], playerXFree + (Window.game.getWidth() - XFREERANGE)/2 - 37, 210, null);
		}
		else{
			g.drawImage(Images.player[playerimg], playerXFree + (Window.game.getWidth() - XFREERANGE)/2 - 37, 210, null);
		}

	}
	
}
