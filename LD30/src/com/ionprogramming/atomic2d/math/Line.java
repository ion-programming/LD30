package com.ionprogramming.atomic2d.math;

import java.awt.geom.Point2D;

public class Line{
	
	private float x1;
	private float y1;
	private float x2;
	private float y2;
	private float m;
	private float c;
	
	public Line(float x3, float y3, float x4, float y4){
		x1 = x3;
		y1 = y3;
		x2 = x4;
		y2 = y4;
		m = (y2 - y1) / (x2 - x1);
		c = - m * x1 + y1;
	}
	
	public Line(Point2D.Float a, Point2D.Float b){
		x1 = a.x;
		y1 = a.y;
		x2 = b.x;
		y2 = b.y;
		m = (y2 - y1) / (x2 - x1);
		c = - m * x1 + y1;
	}
	
	public Line(float x, float y, float slope){
		x1 = x2 = x;
		y1 = y2 = y;
		m = slope;
		c = - m * x1 + y1;
	}
	
	public float getAngle(){
		return GeomMath.angle(x2 - x1, y2 - y1);
	}
	
	public float getX1(){
		return x1;
	}
	
	public float getX2(){
		return x2;
	}
	
	public float getY1(){
		return y1;
	}
	
	public float getY2(){
		return y2;
	}
	
	public float getSlope(){
		return m;
	}
	
	public float getYInt(){
		return c;
	}
	
	public void setX1(float x){
		x1 = x;
		m = (y2 - y1) / (x2 - x1);
		c = - m * x1 + y1;
	}
	
	public void setX2(float x){
		x2 = x;
		m = (y2 - y1) / (x2 - x1);
		c = - m * x1 + y1;
	}
	
	public void setY1(float y){
		y1 = y;
		m = (y2 - y1) / (x2 - x1);
		c = - m * x1 + y1;
	}
	
	public void setY2(float y){
		y2 = y;
		m = (y2 - y1) / (x2 - x1);
		c = - m * x1 + y1;
	}
	
	public float getY(float x){
		return m * x + c;
	}
	
	public float getX(float y){
		return (y - c) / m;
	}
	
	public void setP1(Point2D.Float p){
		x1 = p.x;
		y1 = p.y;
		m = (y2 - y1) / (x2 - x1);
		c = - m * x1 + y1;
	}
	
	public void setP2(Point2D.Float p){
		x2 = p.x;
		y2 = p.y;
		m = (y2 - y1) / (x2 - x1);
		c = - m * x1 + y1;
	}
	
	public Point2D.Float getP1(){
		return new Point2D.Float(x1, y1);
	}
	
	public Point2D.Float getP2(){
		return new Point2D.Float(x2, y2);
	}
	
	public Point2D.Float getMid(){
		return new Point2D.Float((x2 + x1)/2, (y2 + y1)/2);
	}
	
	public Point2D.Float getIntersect(Line a){
		float x = ((a.c - c) / (m - a.m));
		float y = getY(x);
		return new Point2D.Float(x, y);
	}
	
	public Point2D.Float getIntersect(Circle a, boolean pos){
		float x;
		float y;
		float qa = m*m + 1;
		float qb = 2*((c - a.getCentreY())*m - a.getCentreX());
		float qc = a.getCentreX()*a.getCentreX() + c*c + a.getCentreY()*a.getCentreY() - 2*a.getCentreY()*c - a.getRadius()*a.getRadius();
		float det = qb*qb - 4*qa*qc;
		if(det < 0){
			return null;
		}
		else if(det == 0){
			x = -qb/(2*qa);
			y = getY(x);
			return new Point2D.Float(x, y);
		}
		else{
			if(pos){
				x = (float) (-qb + Math.sqrt(det))/(2*qa);
			}
			else{
				x = (float) (-qb - Math.sqrt(det))/(2*qa);
			}
			y = getY(x);
			return new Point2D.Float(x, y);
		}
	}
}
