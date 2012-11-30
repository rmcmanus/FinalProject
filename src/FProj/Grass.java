package FProj;

import java.awt.Color;
import java.awt.Graphics;

public class Grass extends Block{

	public Boolean isGrassBlock() {
		return true;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(this.col * CELLSIZE, this.row * CELLSIZE, CELLSIZE, CELLSIZE);
	}

}
