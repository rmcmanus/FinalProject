package FProj;

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

	}
	
	public ArrayList<Block> getBlocks() {
		return castleBlocks;
	}

}
