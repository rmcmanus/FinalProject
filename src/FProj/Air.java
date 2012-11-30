package FProj;

import java.awt.Color;
import java.awt.Graphics;

public class Air extends Block{
	
	public Boolean isAirBlock() {
		return true;
	}

	public void draw(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(this.col * CELLSIZE, this.row * CELLSIZE, CELLSIZE, CELLSIZE);
		
	}

}
