package FProj;

import java.awt.Graphics;

public class TacoLauncher extends Block{
	double angle = 0;
	double velocity = 0;
	
	public TacoLauncher() {
		
	}
	
	public Boolean isLauncherBlock() {
		return true;
	}
	
	public Projectile throwProjectile() {
		return null;
	}
	
	public void changeLauncher(double angle, double velocity) {
		//this.angle = angle;
		//this.veloctiy = velocity;
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
