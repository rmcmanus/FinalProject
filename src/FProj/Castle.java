package FProj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Castle extends Block{
	private ArrayList<Block> castleBlocks = new ArrayList<Block>();
	
	public Boolean isCastleBlock() {
		return true;
	}

	public void collide() {

	}

	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(this.col * CELLSIZE, this.row * CELLSIZE, CELLSIZE, CELLSIZE);
		g.setColor(Color.BLACK);
		g.drawRect(this.col * CELLSIZE, this.row * CELLSIZE, CELLSIZE, CELLSIZE);
	}
	
	public ArrayList<Block> getBlocks() {
		return castleBlocks;
	}

}
