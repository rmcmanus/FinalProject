package FProj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.Timer;

public class Projectile {
	private int x = 0;
	private int y = 0;
	private double dx;
	private double dy;
	private double angle;
	public static int initialX;
	public static int initialY;
	//private int cannonLength=5;
	boolean landed;

	public Projectile(double dx, double dy, double angle) {
		this.dx = dx;
		this.dy = dy;
		
		this.angle = angle;
		
		this.x = (int) (initialX);
		this.y = (int) (initialY);
	}
	
	public enum Taco {TACO, CHULUPA, DORITOSLOCOS, CANTINABOWL, STEAKQUESADILLA};
	private Taco projectileType;
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, 25, 25);
	}
	
	//Updates the coordinates of the projectile in accordance with accelerations
	public void calcStep() {
		x += dx;
		y += dy;
		dy -= 1;
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
