package FProj;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.Timer;

public class Projectile {
	private double x = 0;
	private double y = 0;
	private double dx;
	private double dy;
	private double angle;
	private int initialX=10;
	private int initialY=10;
	private int cannonLength=5;
	boolean landed;
	Timer timer;
	

	
	
	public Projectile(double initDx, double initDy, double angle) {
		this.dx = initDx;
		this.dy = initDy;
		
		this.angle = angle;
		
		this.x = initialX + Math.cos(angle) * cannonLength;
		this.y = initialY + Math.sin(angle) * cannonLength;
		
		timer = new Timer(100, (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calcStep();
			}
		}
		));
		
	}
	
	public void setTimer(boolean startStop){
		if(timer.isRunning()==true && startStop==false){
			timer.stop();
		}else if(timer.isRunning()==false && startStop == true){
			timer.start();
		}
	}

	public void stepTimer(int steps){
		for(int i=0; i<steps; i++){
			calcStep();
		}
	}
	
	public enum Taco {TACO, CHULUPA, DORITOSLOCOS, CANTINABOWL, STEAKQUESADILLA};
	private Taco projectileType;
	
	public void draw(Graphics g) {
		
	}
	
	//Updates the coordinates of the projectile in accordance with accelerations
	public void calcStep() {
		x += dx;
		y += dy;
		if(y<=0){
			landed = true;
			timer.stop();
		}
	
		
		dy -= 1;
	}
	
	public boolean isLanded(){
		return landed;
	}
	
	public double getX() {
		return this.x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public double getY() {
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
	
	

}
