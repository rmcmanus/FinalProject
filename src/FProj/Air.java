package FProj;

import java.awt.Color;
import java.awt.Graphics;

public class Air extends Block{
	
	public Boolean isAirBlock() {
		return true;
	}

	public void draw(Graphics g) {
		g.setColor( new Color(0x99, 0xcc, 0xff) );
		g.fillRect(this.col * CELLSIZE, this.row * CELLSIZE, CELLSIZE, CELLSIZE);
		
	}

}
