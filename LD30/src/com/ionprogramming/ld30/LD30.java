package com.ionprogramming.ld30;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LD30 extends Applet implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;

	private Image dbImage;
	private Graphics dbg;
	public Color c = new Color(0x000000);
	public static int width = 1000;
	public static int height = 600;

	public static boolean titleScreen = true;

	public void init() {
		setSize(width, height);
		addKeyListener(this);
		setFocusable(true);
		setBackground(c);
		Images.load();
		TitleScreen.load();
	}

	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void stop() {
		System.exit(0);
	}

	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while (true) {
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}

	public void paint(Graphics g) {
		if(titleScreen){
			TitleScreen.render(g);
		}
		else{
			setBackground(Color.red);
			Update.updateGame(g);
		}
		
	}

	public void update(Graphics g) {
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		dbg.setColor(getForeground());
		paint(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {

	}
}
