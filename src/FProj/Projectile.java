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
	public static int initialX;
	public static int initialY;
	
	boolean landed;
	public static Projectile globalProjectile;
	BufferedImage taco = null;
	
	public Projectile(double dx, double dy, double angle) {
		this.dx = dx;
		this.dy = dy;
		this.x = (initialX);
		this.y = (initialY);
		
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
		g.drawImage(taco, this.x - 5, this.y, null);
	}
	
	//Updates the coordinates of the projectile in accordance with accelerations
	public void calcStep() {
		x += dx;
		y += dy;
		dy += 1;
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
	
	public void setTimer(boolean startStop){
		if(FProjMain.getMain().timer.isRunning()==true && startStop==false){
			FProjMain.getMain().timer.stop();
		}else if(FProjMain.getMain().timer.isRunning()==false && startStop == true){
			FProjMain.getMain().timer.start();
		}
	}

	public void stepTimer(int steps){
		for(int i=0; i<steps; i++){
			calcStep();
		}
	}
}
