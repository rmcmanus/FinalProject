package FProj;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Trajectory {
	ArrayList<Integer> trajArray = new ArrayList<Integer>();
	private double dy, dx;
	private int x = 2 * Block.CELLSIZE, y = 16 * Block.CELLSIZE;
	
	public Trajectory() {
		TacoLauncher.getLauncher().getAngle();
		dy = 0;
		dy = (Math.sin(Math.toRadians(-1 * TacoLauncher.getLauncher().getAngle())) * TacoLauncher.getLauncher().getVelocity());
		dx = 0;
		dx = (Math.cos(Math.toRadians(-1 * TacoLauncher.getLauncher().getAngle())) * TacoLauncher.getLauncher().getVelocity());
		
		calcTrajectory();
	}
	
	public void calcTrajectory() {
		for(int i = 0; i < 8; i++) {
			x += dx;
			y += dy;
			dy += 1;
			trajArray.add(x);
			trajArray.add(y);
		}
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < trajArray.size(); i+=2) {
			g.setColor(Color.BLACK);
			g.fillOval(trajArray.get(i) + Block.CELLSIZE, trajArray.get(i + 1), 5, 5);
		}
	}
}
