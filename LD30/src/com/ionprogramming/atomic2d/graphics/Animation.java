package com.ionprogramming.atomic2d.graphics;

public class Animation {

	private int[] imageNum;
	private float[] time;
	private String id = "";
	private float startTime;
	private int frame;
	private boolean loop = true;
	private boolean done = false;
	private boolean paused = false;
	
	public Animation(int[] imgs, float[] t){
		imageNum = imgs;
		time = t;
	}
	
	public Animation(int[] imgs, float[] t, String name){
		imageNum = imgs;
		time = t;
		id = name;
	}
	
	public void togglePause(){
		startTime = System.nanoTime()/1000000 - startTime;
		paused = !paused;
	}
	
	public void setFrame(int f){
		frame = f;
	}
	
	public int getFrame(){
		return frame;
	}
	
	public void setID(String name){
		id = name;
	}
	
	public String getID(){
		return id;
	}
	
	public void setLoop(boolean l){
		loop = l;
	}
	
	public boolean isLoop(){
		return loop;
	}
	
	public boolean isPaused(){
		return paused;
	}
	
	public boolean isFinished(){
		return done;
	}
	
	public void play(){
		startTime = System.nanoTime()/1000000;
		frame = 0;
		done = false;
	}
	
	public int update(){
		if(!paused && !done){
			float t = System.nanoTime()/1000000;
			if(t - startTime >= time[frame]){
				frame++;
				startTime = System.nanoTime()/1000000;
				if(frame >= imageNum.length){
					if(loop){
						play();
					}
					else{
						done = true;
						return imageNum[frame - 1];
					}
				}
			}
		}
		return imageNum[frame];
	}
}
