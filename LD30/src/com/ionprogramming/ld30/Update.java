package com.ionprogramming.ld30;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import com.ionprogramming.ld30.cloudgen.Cloud;
import com.ionprogramming.ld30.cloudgen.Generate;

public class Update {
	
	public static ArrayList<Cloud> clouds = new ArrayList<Cloud>();

	static int numCloud = 5;
	static Random r = new Random();
	static float trans = 1f;
	
	static int walkTick = 0;
	
	public static void updateGame(Graphics g){
		g.drawImage(Images.sun, 700, -50, null);
		int a = numCloud - Update.clouds.size();
		while(a > 0){
			Update.clouds.add(new Cloud(Generate.gen(), 1000, r.nextInt(300)-150, 0, r.nextDouble() + 0.2));
			a--;
		}
		for(int c = 0; c < Update.clouds.size(); c++){
			if(Update.clouds.get(c).draw(g)){
				c--;
			}
		}
		boolean wt = false;
		if(walkTick >= 10){
			wt = true;
			walkTick = 0;
		}
		
		if(Input.right && !Input.left){
			trans -= 0.01;
			Cloud.right = true;
			Cloud.left = false;
			Map.left = false;;
			if(wt){
				wt = false;
				Map.playerimg ++;
				if(Map.playerimg > 3){
					Map.playerimg = 0;
				}
			}
			Map.playerXFree += 5;
			if(Map.playerXFree > Map.XFREERANGE){
				Map.playerX += Map.playerXFree - Map.XFREERANGE;
				Map.playerXFree = Map.XFREERANGE;
			}
		}
		else if(!Input.right && Input.left){
			trans -= 0.01;
			Cloud.left = true;
			Cloud.right = false;
			Map.left = true;;
			if(wt){
				wt = false;
				Map.playerimg ++;
				if(Map.playerimg > 3){
					Map.playerimg = 0;
				}
			}
			Map.playerXFree -= 5;
			if(Map.playerXFree < 0){
				Map.playerX += Map.playerXFree;
				Map.playerXFree = 0;
			}
		}
		else{
			Cloud.left = false;
			Cloud.right = false;
		}
		Map.draw(g);
		if(trans >= 0.005f){
			Graphics2D g2 = (Graphics2D)g;
			Composite d = g2.getComposite();
			
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, trans));
			g2.drawImage(Images.title, LD30.width/2 - Images.title.getWidth()/2, LD30.height/2 - Images.title.getHeight()/2, null);
			g2.setComposite(d);
		}
		
		walkTick++;
	}
	
}
