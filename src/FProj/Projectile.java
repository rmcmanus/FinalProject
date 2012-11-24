package FProj;

import java.awt.Graphics;

public class Projectile {
	private double x = 0;
	private double y = 0;
	private double dx;
	private double dy;
	
	public Projectile(double initDx, double initDy) {
		this.dx = initDx;
		this.dy = initDy;
	}
	
	public enum Taco {TACO, CHULUPA, DORITOSLOCOS, CANTINABOWL, STEAKQUESADILLA};
	private Taco projectileType;
	
	public void draw(Graphics g) {
		
	}
	
	//Updates the coordinates of the projectile in accordance with accelerations
	public void calcStep() {
		x += dx;
		y += dy;
		
		dy -= 1;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}

}
