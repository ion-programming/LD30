package com.ionprogramming.atomic2d.collisionbodies;

import java.awt.geom.Point2D;

public class BoxCollisionBody extends CollisionBody {
	
	private float width = 0;
	private float height = 0;
	
	public float getWidth(){
		return width;
	}
	
	public void setWidth(float w){
		width = w;
	}
	
	public float getHeight(){
		return height;
	}
	
	public void setHeight(float h){
		height = h;
	}
	
	public void setSize(float w, float h){
		width = w;
		height = h;
	}
	
	public Point2D.Float getSize(){
		return new Point2D.Float(width, height);
	}
}