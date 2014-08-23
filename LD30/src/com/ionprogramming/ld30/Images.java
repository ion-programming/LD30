package com.ionprogramming.ld30;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public static BufferedImage ld;
	
	public static void load(){
		try {
			ld = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/ld.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
