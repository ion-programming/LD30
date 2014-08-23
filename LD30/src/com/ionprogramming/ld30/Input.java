package com.ionprogramming.ld30;

import java.awt.event.KeyEvent;

public class Input {
	
	public static boolean right = false;
	public static boolean left = false;

	public static void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D){
			right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A){
			left = true;
		}
	}

	public static void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D){
			right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A){
			left = false;
		}
	}

	public static void keyTyped(KeyEvent e) {

	}
}
