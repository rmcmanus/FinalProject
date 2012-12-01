package FProj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Projectile {
	private int x = 0;
	private int y = 0;
	private double dx;
	private double dy;
	private double angle;
	public static int initialX;
	public static int initialY;
	public int trajX = 0;
	public int trajY = 0;
	public double trajDX, trajDY;
	
	boolean landed;
	public static Projectile globalProjectile;
	BufferedImage taco = null;
	
	public Projectile(double dx, double dy, double angle) {
		this.dx = dx;
		this.dy = dy;
		
		this.angle = angle;
		
		this.x = (initialX);
		this.y = (initialY);
		
		trajX = initialX;
		trajY = initialY;
		trajDX = dx;
		trajDY = dy;
		
		try {
			taco = ImageIO.read(new File("av-33.gif"));
		} catch (IOException e) {
		}
		
		globalProjectile = this;
	}
	
	//public enum Taco {TACO};
	public static Projectile getProj() {
		return globalProjectile;
	}
	
	public void draw(Graphics g) {
		/*
		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, 25, 25);
		*/
		//g.drawImage(taco, this.x, this.y, null);
	}
	
	public void drawTrajectory(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(this.trajX, this.trajY, Block.CELLSIZE, Block.CELLSIZE);
	}
	
	//Updates the coordinates of the projectile in accordance with accelerations
	public void calcStep() {
		x += dx;
		y += dy;
		dy += 1;
	}
	
	public void calcTrajectory() {
		trajX += trajDX;
		trajY += trajDY;
		trajDY += Block.CELLSIZE;
	}
	
	//////////////
	
	public boolean isLanded(){
		return landed;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y){
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}
	
	/*public void setTimer(boolean startStop){
		if(timer.isRunning()==true && startStop==false){
			timer.stop();
		}else if(timer.isRunning()==false && startStop == true){
			timer.start();
		}
	}*/

	public void stepTimer(int steps){
		for(int i=0; i<steps; i++){
			calcStep();
		}
	}
}
