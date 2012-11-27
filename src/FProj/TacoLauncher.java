package FProj;

import java.awt.Graphics;

public class TacoLauncher extends Block{
	double angle = 0;
	double velocity = 0;
	double dy;
	double dx;
	
	public TacoLauncher() {
		
	}
	
	public Boolean isLauncherBlock() {
		return true;
	}
	
	public Projectile throwProjectile() {
		//calc initial dy
		dy = 0;
		dy = (Math.sin(angle) * velocity);
		//calc initial dx
		dx = 0;
		dx = (Math.cos(angle) * velocity);
		
		return new Projectile(dx, dy, angle);
	}
	
	public void changeLauncher(double angle, double velocity) {
		this.angle = angle;
		this.velocity = velocity;
	}
	
	public void draw(Graphics g) {

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
