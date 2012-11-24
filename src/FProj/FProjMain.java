package FProj;

import java.util.ArrayList;

public class FProjMain {

	ArrayList<Block> blocks = new ArrayList<Block>();
	Projectile projectile;
	
	public FProjMain() {
		loadMapFromFile();
	}

	public void loadMapFromFile() {
		for(int i = 0; i < 468; i++)
			blocks.add(new Air());
	}
	
	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 */

}
