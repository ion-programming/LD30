package com.ionprogramming.ld30;

import java.awt.event.KeyEvent;

public class Input {

	public static void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D){
			Map.playerXFree += 5;
			if(Map.playerXFree > Map.XFREERANGE){
				Map.playerX += Map.playerXFree - Map.XFREERANGE;
				Map.playerXFree = Map.XFREERANGE;
			}
		}
		else if( e.getKeyCode() == KeyEvent.VK_A){
			Map.playerXFree -= 5;
			if(Map.playerXFree < 0){
				Map.playerX += Map.playerXFree;
				Map.playerXFree = 0;
			}
		}
	}

	public static void keyReleased(KeyEvent e) {
		
	}

	public static void keyTyped(KeyEvent e) {

	}
}
