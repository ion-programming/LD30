package com.ionprogramming.ld30;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public static BufferedImage ld;
	public static BufferedImage ion;
	public static BufferedImage map1;
	public static BufferedImage titleLoad;
	public static BufferedImage title;
	public static BufferedImage bf1;
	public static BufferedImage bf2;
	public static BufferedImage playerTiles;
	public static BufferedImage[] player;
	public static BufferedImage sun;
	
	public static void load(){
		try {
			ld = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/ld.png"));
			ion = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/ion.png"));
			map1 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/level1.png"));
			titleLoad = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/title.png"));
			title = new BufferedImage(titleLoad.getWidth(), titleLoad.getHeight(), BufferedImage.TYPE_INT_ARGB);
			title.getGraphics().drawImage(titleLoad, 0, 0, null);
			bf1 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/buttfly1.png"));
			bf2 = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/buttfly2.png"));
			playerTiles = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/player.png"));
			player = ImageHandler.splitImage(playerTiles, 4, 2, 1);
			sun = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/sun.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
