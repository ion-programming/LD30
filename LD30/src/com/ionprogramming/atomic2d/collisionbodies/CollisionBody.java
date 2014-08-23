package com.ionprogramming.atomic2d.collisionbodies;

import java.awt.geom.Point2D;

import com.ionprogramming.atomic2d.math.GeomMath;

public class CollisionBody {

	private float xpos = 0;
	private float ypos = 0;
	private float xv = 0;
	private float yv = 0;
	private float xa = 0;
	private float ya = 0;
	private float mass = 1;
	private float bounce = 0;
	private float friction = 0;
	private boolean fixed = false;
	private boolean dynamic = false;
	
	public void setDynamic(boolean d){
		dynamic = d;
	}
	
	public boolean isDynamic(){
		return dynamic;
	}
	
	public void setFixed(boolean f){
		fixed = f;
	}
	
	public void setBounce(float b){
		bounce = b;
	}
	
	public float getBounce(){
		return bounce;
	}
	
	public void setFriction(float f){
		friction = f;
	}
	
	public float getFriction(){
		return friction;
	}
	
	public void setX(float x){
		xpos = x;
	}
	
	public float getX(){
		return xpos;
	}
	
	public void setY(float y){
		ypos = y;
	}
	
	public float getY(){
		return ypos;
	}
	
	public void setMass(float m){
		mass = m;
	}
	
	public float getMass(){
		return mass;
	}
	
	public boolean isFixed(){
		return fixed;
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
	
	public Point2D.Float getCentre(){
		return new Point2D.Float(xpos, ypos);
	}
	
	public void setCentre(Point2D.Float p){
		xpos = p.x;
		ypos = p.y;
	}
	
	public void setCentre(float x, float y){
		xpos = x;
		ypos = y;
	}
	
	public Point2D.Float getVel(){
		return new Point2D.Float(xv, yv);
	}
	
	public void setVel(Point2D.Float p){
		xv = p.x;
		yv = p.y;
	}
	
	public Point2D.Float getAcc(){
		return new Point2D.Float(xa, ya);
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
}
