package com.ionprogramming.ld30;

import java.awt.Graphics;

public class Update {
	
	public static void updateGame(Graphics g){
		if(Input.right && !Input.left){
			Map.playerXFree += 5;
			if(Map.playerXFree > Map.XFREERANGE){
				Map.playerX += Map.playerXFree - Map.XFREERANGE;
				Map.playerXFree = Map.XFREERANGE;
			}
		}
		else if(!Input.right && Input.left){
			Map.playerXFree -= 5;
			if(Map.playerXFree < 0){
				Map.playerX += Map.playerXFree;
				Map.playerXFree = 0;
			}
		}
		Map.draw(g);
	}
	
}
