package FProj;

import java.awt.Color;
import java.awt.Graphics;

public class TacoLauncher extends Block{
	double angle = 0;
	double velocity = 0;
	double dy;
	double dx;
	public static TacoLauncher globalLauncher;
	
	public TacoLauncher() {
		globalLauncher = this;
	}
	
	public Boolean isLauncherBlock() {
		return true;
	}
	
	public static TacoLauncher getLauncher() {
		return globalLauncher;
	}
	
	public Projectile throwProjectile() {
		//calc initial dy
		dy = 0;
		dy = (Math.sin(Math.toRadians(-1 * angle)) * velocity);
		//calc initial dx
		dx = 0;
		dx = (Math.cos(Math.toRadians(-1 * angle)) * velocity);
		
		return new Projectile(dx, dy, -1 * angle);
	}
	
	public void changeAngle(double angle) {
		this.angle = angle;
	}
	
	public void changeVelocity(double velocity) {
		this.velocity = velocity;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(this.col * CELLSIZE, this.row * CELLSIZE, CELLSIZE, CELLSIZE);
	}
	
//////////////////////////////////////////////////////////////////
	//Here lies TestLand
	//
	//Beware all ye who enter
//////////////////////////////////////////////////////////////////
	public double getAngle() {
		return angle;
	}
	

	
	public double getVelocity() {
		return velocity;
	}
	
	
	
}
