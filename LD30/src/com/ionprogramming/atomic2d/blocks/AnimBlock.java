package com.ionprogramming.atomic2d.blocks;

import java.util.ArrayList;

import com.ionprogramming.atomic2d.graphics.Animation;

public class AnimBlock extends MovingBlock {

	private ArrayList<Animation> animations = new ArrayList<Animation>();
	private String currentAnim;
	
	@Override
	public void update(){
		super.update();
		if(!isPaused()){
			setCurrentImage(getAnim(currentAnim).update());
		}
	}
	
	@Override
	public void togglePaused(){
		super.togglePaused();
		getAnim(currentAnim).togglePause();
	}
	
	public void playAnim(String id){
		currentAnim = id;
		getAnim(currentAnim).play();
	}
	
	public void setAnims(ArrayList<Animation> anims){
		animations = anims;
	}
	
	public ArrayList<Animation> getAnims(){
		return animations;
	}
	
	public void addAnim(Animation anim){
		animations.add(anim);
	}
	
	public void addAnim(Animation anim, int index){
		animations.add(index, anim);
	}
	
	public Animation getAnim(String id){
		for(int n = 0; n < animations.size(); n++){
			if(animations.get(n).getID().equals(id)){
				return animations.get(n);
			}
		}
		return null;
	}
	
	public Animation getAnim(int index){
		return animations.get(index);
	}
	
	public boolean isCurrentAnimFinished(){
		return getAnim(currentAnim).isFinished();
	}
	
	public String getCurrentAnimID(){
		return currentAnim;
	}
}
