package com.ionprogramming.atomic2d.math;

import java.awt.geom.Point2D;

public class GeomMath {
	
	public static float length(float x, float y){
		return (float) Math.sqrt(x*x + y*y);
	}
	
	public static float angle(float x, float y){
		if(x == 0 && y == 0){
			return 0;
		}
		float a = (float) Math.toDegrees(Math.atan(y/x));
		if(x < 0){
			a = 180 - a;
		}
		else{
			a = 360 - a;
			if(a >= 360){
				a-= 360;
			}
		}
		return a;
	}
	
	public static Point2D.Float rotate(float d, float angle){
		return new Point2D.Float((float) (d*Math.cos(Math.toRadians(360 - angle))), (float) (d*Math.sin(Math.toRadians(360 - angle))));
	}
	
	public static Point2D.Float rotate(float x, float y, float angle){
		float a = 360 - (angle(x, y) + angle);
		float d = length(x, y);
		return rotate(d, a);
	}
}
