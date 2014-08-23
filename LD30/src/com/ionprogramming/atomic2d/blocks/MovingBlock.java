package com.ionprogramming.atomic2d.blocks;

import java.awt.geom.Point2D;

import com.ionprogramming.atomic2d.math.GeomMath;

public class MovingBlock extends Block {
	
	private float xv = 0;
	private float yv = 0;
	private float xa = 0;
	private float ya = 0;
	private float time = 0;
	private boolean paused = false;
	
	public void update(){
		if(!paused){
			if(time == 0){
				time = System.nanoTime()/1000000000f;
				if(collisionBody != null){
					setCollisionStats();
				}
			}
			else{
				float t = System.nanoTime()/1000000000f;
				setX(getX() + xv*(t - time));
				setY(getY() + yv*(t - time));
				xv += xa*(t - time);
				yv += ya*(t - time);
				if(collisionBody != null){
					setCollisionStats();
				}
				time = t;
			}
		}
	}
	
	public void togglePaused(){
		paused = !paused;
		if(!paused){
			time = System.nanoTime()/1000000000f;
		}
	}
	
	public boolean isPaused(){
		return paused;
	}
	
	public Point2D.Float getVel(){
		return new Point2D.Float(xv, yv);
	}
	
	public Point2D.Float getAcc(){
		return new Point2D.Float(xa, ya);
	}
	
	public float getXVel(){
		return xv;
	}
	
	public void setXVel(float x){
		xv = x;
	}
	
	public float getYVel(){
		return yv;
	}
	
	public void setYVel(float y){
		yv = y;
	}
	
	public void setVel(float x, float y){
		xv = x;
		yv = y;
	}

	public void setVel(Point2D.Float p){
		xv = p.x;
		yv = p.y;
	}
	
	public float getXAcc(){
		return xa;
	}
	
	public void setXAcc(float x){
		xa = x;
	}
	
	public float getYAcc(){
		return ya;
	}
	
	public void setYAcc(float y){
		ya = y;
	}
	
	public void setAcc(float x, float y){
		xa = x;
		ya = y;
	}
	
	public void setAcc(Point2D.Float p){
		xa = p.x;
		ya = p.y;
	}
	
	public float getVelLength(){
		return GeomMath.length(xv, yv);
	}
	
	public float getAccLength(){
		return GeomMath.length(xa, ya);
	}
	
	public float getVelAngle(){
		return GeomMath.angle(xv, yv);
	}
	
	public float getAccAngle(){
		return GeomMath.angle(xa, ya);
	}
	
	public float getDistanceTo(float x, float y){
		return GeomMath.length(x - getX(), y - getY());
	}
	
	public float getAngleTo(float x, float y){
		return GeomMath.angle(x - getX(), y - getY());
	}
	
	public float getAngleFrom(float x, float y){
		return GeomMath.angle(getX() - x, getY() - y);
	}
	
	@Override
	public void setToCollisionStats(){
		super.setToCollisionStats();
		setVel(collisionBody.getVel());
		setAcc(collisionBody.getAcc());
	}
	
	@Override
	public void setCollisionStats(){
		super.setCollisionStats();
		collisionBody.setVel(getVel());
		collisionBody.setAcc(getAcc());
	}
}
