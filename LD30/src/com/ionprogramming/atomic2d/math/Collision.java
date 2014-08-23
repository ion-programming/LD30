package com.ionprogramming.atomic2d.math;

import com.ionprogramming.atomic2d.blocks.Block;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.atomic2d.collisionbodies.CircleCollisionBody;

public class Collision {
	
	@SuppressWarnings("unused")
	public static boolean checkCollide(Block b, Block b1){
		boolean hit = false;
		if(b.collisionBody != null && b1.collisionBody != null){
			if(b.collisionBody.getClass() == CircleCollisionBody.class){
				CircleCollisionBody c = (CircleCollisionBody) b.collisionBody;
				if(b1.collisionBody.getClass() == CircleCollisionBody.class){
					CircleCollisionBody c1 = (CircleCollisionBody) b1.collisionBody;
					float d = GeomMath.length(c.getX() - c1.getX(), c.getY() - c1.getY());
					if(d < c.getRadius() + c1.getRadius()){
						
					}
				}
				else if(b1.collisionBody.getClass() == BoxCollisionBody.class){
					BoxCollisionBody c1 = (BoxCollisionBody) b1.collisionBody;
				}
			}
			else if(b.collisionBody.getClass() == BoxCollisionBody.class){
				BoxCollisionBody c = (BoxCollisionBody) b.collisionBody;
				if(b1.collisionBody.getClass() == CircleCollisionBody.class){
					CircleCollisionBody c1 = (CircleCollisionBody) b1.collisionBody;
					
				}
				else if(b1.collisionBody.getClass() == BoxCollisionBody.class){
					BoxCollisionBody c1 = (BoxCollisionBody) b1.collisionBody;
					float xd = c.getX() - c1.getX();
					float yd = c.getY() - c1.getY();
					if(Math.abs(xd) < (c.getWidth() + c1.getWidth())/2){
						if(Math.abs(yd) < (c.getHeight() + c1.getHeight())/2){
							hit = true;
						}
					}
				}
			}
		}
		return hit;
	}
	
	@SuppressWarnings("unused")
	public static boolean collide(Block b, Block b1){
		boolean hit = false;
		if(b.collisionBody != null && b1.collisionBody != null){
			if(b.collisionBody.getClass() == CircleCollisionBody.class){
				CircleCollisionBody c = (CircleCollisionBody) b.collisionBody;
				if(b1.collisionBody.getClass() == CircleCollisionBody.class){
					CircleCollisionBody c1 = (CircleCollisionBody) b1.collisionBody;
					float d = GeomMath.length(c.getX() - c1.getX(), c.getY() - c1.getY());
					if(d < c.getRadius() + c1.getRadius()){
						
					}
				}
				else if(b1.collisionBody.getClass() == BoxCollisionBody.class){
					BoxCollisionBody c1 = (BoxCollisionBody) b1.collisionBody;
				}
			}
			else if(b.collisionBody.getClass() == BoxCollisionBody.class){
				BoxCollisionBody c = (BoxCollisionBody) b.collisionBody;
				if(b1.collisionBody.getClass() == CircleCollisionBody.class){
					CircleCollisionBody c1 = (CircleCollisionBody) b1.collisionBody;
					
				}
				else if(b1.collisionBody.getClass() == BoxCollisionBody.class){
					BoxCollisionBody c1 = (BoxCollisionBody) b1.collisionBody;
					float xd = c.getX() - c1.getX();
					float yd = c.getY() - c1.getY();
					if(Math.abs(xd) < (c.getWidth() + c1.getWidth())/2){
						if(Math.abs(yd) < (c.getHeight() + c1.getHeight())/2){
							hit = true;
//							MOVE FASTEST OBJECT BACK TO MOMENT OF COLLISION
							if(!c.isFixed() || !c1.isFixed()){
								if(c.getXVel() == 0 && c.getYVel() == 0 && c1.getXVel() == 0 && c1.getYVel() == 0){
									float x = xd - (c.getWidth() + c1.getWidth())/2;
									float x2 = xd + (c.getWidth() + c1.getWidth())/2;
									if(Math.abs(x2) < Math.abs(x)){
										x = x2;
									}
									float y = yd - (c.getWidth() + c1.getWidth())/2;
									float y2 = yd + (c.getWidth() + c1.getWidth())/2;
									if(Math.abs(y2) < Math.abs(y)){
										y = y2;
									}
									if(Math.abs(x) < Math.abs(y)){
										if(c.isFixed()){
											c1.setX(c1.getX() + x);
										}
										else if(c1.isFixed()){
											c.setX(c.getX() - x);
										}
										else{
											c.setX(c.getX() - x/2);
											c1.setX(c1.getX() + x/2);
										}
									}
									else{
										if(c.isFixed()){
											c1.setY(c1.getY() + y);
										}
										else if(c1.isFixed()){
											c.setY(c.getY() - y);
										}
										else{
											c.setY(c.getY() - y/2);
											c1.setY(c1.getY() + y/2);
										}
									}
								}
								else{
									boolean x = false;
									if(c.isFixed()){
										float xt = (xd - (c.getWidth() + c1.getWidth())/2)/c1.getXVel();
										float xt2 = (xd + (c.getWidth() + c1.getWidth())/2)/c1.getXVel();
										if(Math.abs(xt2) < Math.abs(xt)){
											xt = xt2;
										}
										float yt = (yd - (c.getHeight() + c1.getHeight())/2)/c1.getYVel();
										float yt2 = (yd + (c.getHeight() + c1.getHeight())/2)/c1.getYVel();
										if(Math.abs(yt2) < Math.abs(yt)){
											yt = yt2;
										}
										if(Math.abs(xt) < Math.abs(yt)){
											x = true;
											c1.setCentre(c1.getX() + xt*c1.getXVel(), c1.getY() + xt*c1.getYVel());
										}
										else{
											c1.setCentre(c1.getX() + yt*c1.getXVel(), c1.getY() + yt*c1.getYVel());
										}
									}
									else if(c1.isFixed()){
										float xt = (-xd - (c.getWidth() + c1.getWidth())/2)/c.getXVel();
										float xt2 = (-xd + (c.getWidth() + c1.getWidth())/2)/c.getXVel();
										if(Math.abs(xt2) < Math.abs(xt)){
											xt = xt2;
										}
										float yt = (-yd - (c.getHeight() + c1.getHeight())/2)/c.getYVel();
										float yt2 = (-yd + (c.getHeight() + c1.getHeight())/2)/c.getYVel();
										if(Math.abs(yt2) < Math.abs(yt)){
											yt = yt2;
										}
										if(Math.abs(xt) < Math.abs(yt)){
											x = true;
											c.setCentre(c.getX() + xt*c.getXVel(), c.getY() + xt*c.getYVel());
											
										}
										else{
											c.setCentre(c.getX() + yt*c.getXVel(), c.getY() + yt*c.getYVel());
										}
									}
									else{
										if(c.getVelLength() > c1.getVelLength()){
											float xt = (-xd - (c.getWidth() + c1.getWidth())/2)/c.getXVel();
											float xt2 = (-xd + (c.getWidth() + c1.getWidth())/2)/c.getXVel();
											if(Math.abs(xt2) < Math.abs(xt)){
												xt = xt2;
											}
											float yt = (-yd - (c.getHeight() + c1.getHeight())/2)/c.getYVel();
											float yt2 = (-yd + (c.getHeight() + c1.getHeight())/2)/c.getYVel();
											if(Math.abs(yt2) < Math.abs(yt)){
												yt = yt2;
											}
											if(Math.abs(xt) < Math.abs(yt)){
												x = true;
												c.setCentre(c.getX() + xt*c.getXVel(), c.getY() + xt*c.getYVel());
											}
											else{
												c.setCentre(c.getX() + yt*c.getXVel(), c.getY() + yt*c.getYVel());
											}
										}
										else{
											float xt = (xd - (c.getWidth() + c1.getWidth())/2)/c1.getXVel();
											float xt2 = (xd + (c.getWidth() + c1.getWidth())/2)/c1.getXVel();
											if(Math.abs(xt2) < Math.abs(xt)){
												xt = xt2;
											}
											float yt = (yd - (c.getHeight() + c1.getHeight())/2)/c1.getYVel();
											float yt2 = (yd + (c.getHeight() + c1.getHeight())/2)/c1.getYVel();
											if(Math.abs(yt2) < Math.abs(yt)){
												yt = yt2;
											}
											if(Math.abs(xt) < Math.abs(yt)){
												x = true;
												c1.setCentre(c1.getX() + xt*c1.getXVel(), c1.getY() + xt*c1.getYVel());
											}
											else{
												c1.setCentre(c1.getX() + yt*c1.getXVel(), c1.getY() + yt*c1.getYVel());
											}
										}
									}
	//								NOW ADJUST VELOCITY FOR REBOUND, SLIDE, ETC.
									if(!c.isDynamic() && !c1.isDynamic()){
										c.setVel(0, 0);
										c1.setVel(0, 0);
									}
									else if(!c.isDynamic()){
										if(x){
											c1.setVel(-c1.getXVel()*c1.getBounce()*c.getBounce(), c1.getYVel()*c1.getFriction()*c.getFriction());
										}
										else{
											c1.setVel(c1.getXVel()*c1.getFriction()*c.getFriction(), -c1.getYVel()*c1.getBounce()*c.getBounce());
										}
										c.setVel(0, 0);
									}
									else if(!c1.isDynamic()){
										if(x){
											c.setVel(-c.getXVel()*c1.getBounce()*c.getBounce(), c.getYVel()*c1.getFriction()*c.getFriction());
										}
										else{
											c.setVel(c.getXVel()*c1.getFriction()*c.getFriction(), -c.getYVel()*c1.getBounce()*c.getBounce());
										}
										c1.setVel(0, 0);
									}
									else{
										if(x){
											float p = c.getMass()*c.getXVel() + c1.getMass()*c1.getXVel();
											c.setVel((-c.getXVel() + c.getMass()*p)*c1.getBounce()*c.getBounce(), c.getYVel()*c1.getFriction()*c.getFriction());
											c1.setVel((-c1.getXVel() + c1.getMass()*p)*c1.getBounce()*c.getBounce(), c1.getYVel()*c1.getFriction()*c.getFriction());
										}
										else{
											float p = c.getMass()*c.getYVel() + c1.getMass()*c1.getYVel();
											c.setVel(c.getXVel()*c1.getFriction()*c.getFriction(), (-c.getYVel() + c.getMass()*p)*c1.getBounce()*c.getBounce());
											c1.setVel(c1.getXVel()*c1.getFriction()*c.getFriction(), (-c1.getYVel() + c1.getMass()*p)*c1.getBounce()*c.getBounce());
										}
									}
									if(c.isFixed()){
										c.setVel(0, 0);
									}
									else if(c1.isFixed()){
										c1.setVel(0, 0);
									}
								}
							}
						}
					}
				}
			}
			b.setToCollisionStats();
			b1.setToCollisionStats();
		}
		return hit;
	}
}
