package com.ionprogramming.ld30.cloudgen;
public class BoxBlurFilter{

	private int hRadius;
	private int vRadius;
	private int iterations = 1;
	
    public int[] filter(int[] inPixels, int width){
        int height = inPixels.length/width;
        int[] outPixels = new int[width*height];
        for (int i = 0; i < iterations; i++){
            blur(inPixels, outPixels, width, height, hRadius);
            blur(outPixels, inPixels, height, width, vRadius);
        }
        return inPixels;
    }

    public static void blur(int[] in, int[] out, int width, int height, int radius){
        int tableSize = 2*radius+1;
        int divide[] = new int[256*tableSize];
        for(int i = 0; i < 256*tableSize; i++){
            divide[i] = i/tableSize;
        }
        int inIndex = 0;
        for(int y = 0; y < height; y++){
            int outIndex = y;
            int ta = 0, tr = 0, tg = 0, tb = 0;
            for(int i = -radius; i <= radius; i++){
                int rgb = in[inIndex + clamp(i, 0, width-1)];
                ta += (rgb >> 24) & 0xff;
                tr += (rgb >> 16) & 0xff;
                tg += (rgb >> 8) & 0xff;
                tb += rgb & 0xff;
            }
            for(int x = 0; x < width; x++){
                out[outIndex] = (divide[ta] << 24)|(divide[tr] << 16)|(divide[tg] << 8)|divide[tb];
                int i1 = x+radius+1;
                if(i1 > width - 1){
                    i1 = width - 1;
                }
                int i2 = x-radius;
                if(i2 < 0){
                    i2 = 0;
                }
                int rgb1 = in[inIndex+i1];
                int rgb2 = in[inIndex+i2];
                ta += ((rgb1 >> 24) & 0xff)-((rgb2 >> 24) & 0xff);
                tr += ((rgb1 & 0xff0000)-(rgb2 & 0xff0000)) >> 16;
                tg += ((rgb1 & 0xff00)-(rgb2 & 0xff00)) >> 8;
                tb += (rgb1 & 0xff)-(rgb2 & 0xff);
                outIndex += height;
            }
            inIndex += width;
        }
    }
    
    public static int clamp(int x, int a, int b) {
		return (x < a) ? a : (x > b) ? b : x;
	}
        
	public void setHRadius(int hRadius){
		this.hRadius = hRadius;
	}
	
	public int getHRadius(){
		return hRadius;
	}
	
	public void setVRadius(int vRadius){
		this.vRadius = vRadius;
	}
	
	public int getVRadius(){
		return vRadius;
	}
	
	public void setRadius(int radius){
		this.hRadius = this.vRadius = radius;
	}
	
	public int getRadius(){
		return hRadius;
	}
	
	public void setIterations(int iterations){
		this.iterations = iterations;
	}
	
	public int getIterations(){
		return iterations;
	}
	
	public String toString(){
		return "Blur/Box Blur...";
	}
}