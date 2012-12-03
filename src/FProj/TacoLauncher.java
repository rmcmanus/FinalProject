package FProj;

import java.awt.Color;
import java.awt.Graphics;

public class TacoLauncher extends Block{
	static double angle = 0;
	static double velocity = 0;
	double dy, dx;
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

		//ADD Trajectory calculations
		//calc initial dy
		return new Projectile(dx, dy, -1 * angle);
	}

	public void changeAngle(double angle) {
		this.angle = angle;
		FProjMain.getMain().trajectory = new Trajectory();
	}

	public void changeVelocity(double velocity) {
		this.velocity = velocity;
		FProjMain.getMain().trajectory = new Trajectory();
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
