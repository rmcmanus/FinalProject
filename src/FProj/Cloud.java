package FProj;

import java.awt.Color;
import java.awt.Graphics;

public class Cloud extends Block{
	
	public Boolean isCloudBlock() {
		return true;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(this.col * CELLSIZE, this.row * CELLSIZE, CELLSIZE, CELLSIZE);
	}

}
