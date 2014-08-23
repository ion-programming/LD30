package com.ionprogramming.atomic2d.math;

import java.awt.geom.Point2D;

public class Circle {

	private float x;
	private float y;
	private float r;
	
	public Circle(float xc, float yc, float radius){
		x = xc;
		y = yc; 
		r = radius;
	}
	
	public Circle(Point2D.Float p, float radius){
		x = p.x;
		y = p.y; 
		r = radius;
	}
	
	public float getCentreX(){
		return x;
	}
	
	public float getCentreY(){
		return y;
	}
	
	public Point2D.Float getCentre(){
		return new Point2D.Float(x, y);
	}
	
	public float getRadius(){
		return r;
	}
	
	public void setCentreX(float cx){
		x = cx;
	}
	
	public void setCentreY(float cy){
		y = cy;
	}
	
	public void setCentre(Point2D.Float c){
		x = c.x;
		y = c.y;
	}
	
	public void setRadius(float radius){
		r = radius;
	}
	
	public float getY(float xp, boolean pos){
		float qa = 1;
		float qb = -2*y;
		float qc = y*y + (xp - x)*(xp - x) - r*r;
		float det = qb*qb - 4*qa*qc;
		if(det < 0){
			return Float.NaN;
		}
		else if(det == 0){
			return -qb/(2*qa);
		}
		else{
			float yp;
			if(pos){
				yp = (float) (-qb + Math.sqrt(det))/(2*qa);
			}
			else{
				yp = (float) (-qb - Math.sqrt(det))/(2*qa);
			}
			return yp;
		}
	}
	
	public float getX(float yp, boolean pos){
		float qa = 1;
		float qb = -2*x;
		float qc = x*x + (yp - x)*(yp - x) - r*r;
		float det = qb*qb - 4*qa*qc;
		if(det < 0){
			return Float.NaN;
		}
		else if(det == 0){
			return -qb/(2*qa);
		}
		else{
			float xp;
			if(pos){
				xp = (float) (-qb + Math.sqrt(det))/(2*qa);
			}
			else{
				xp = (float) (-qb - Math.sqrt(det))/(2*qa);
			}
			return xp;
		}
	}
	
	public Point2D.Float getIntersect(Line a, boolean pos){
		float xp;
		float yp;
		float qa = a.getSlope()*a.getSlope() + 1;
		float qb = 2*((a.getYInt() - y)*a.getSlope() - x);
		float qc = x*x + a.getYInt()*a.getYInt() + y*y - 2*y*a.getYInt() - r*r;
		float det = qb*qb - 4*qa*qc;
		if(det < 0){
			return null;
		}
		else if(det == 0){
			xp = -qb/(2*qa);
			yp = a.getY(xp);
			return new Point2D.Float(xp, yp);
		}
		else{
			if(pos){
				xp = (float) (-qb + Math.sqrt(det))/(2*qa);
			}
			else{
				xp = (float) (-qb - Math.sqrt(det))/(2*qa);
			}
			yp = a.getY(xp);
			return new Point2D.Float(xp, yp);
		}
	}
}
