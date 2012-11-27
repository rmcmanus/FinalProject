package FProj;

import java.awt.Color;

public abstract class Block {
	private Color color;
	public final static int CELLSIZE = 25;
	Integer row, col, index;
	Character charName;
	
	public Boolean isCastleBlock() {
		return false;
	}
	public Boolean isLauncherBlock() {
		return false;
	}
	public Boolean isCloudBlock() {
		return false;
	}
	public Boolean isGrassBlock() {
		return false;
	}
	public Boolean isAirBlock() {
		return false;
	}
	
	////////
	public Integer getRow() {
		return row;
	}
	public Integer getCol() {
		return col;
	}
	
	
	
}
