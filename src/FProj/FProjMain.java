package FProj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FProjMain {

	ArrayList<Block> blocks = new ArrayList<Block>();
	Map<Character, String> legend = new TreeMap<Character, String>();
	Projectile projectile;
	int numRows = 0;

	public FProjMain() {
		loadLegend();
		loadMapFromFile();
	}

	public void loadMapFromFile() {
		try {
			FileReader inputReader = new FileReader("config.txt");
			Scanner in = new Scanner(inputReader);
			String delimiter = ",";

			while(in.hasNextLine()) {
				String line = in.nextLine();
				String[] temp = line.split(delimiter);
				for(int i = 0; i < temp.length; i++) {
					System.out.println(temp[i]);
					if(temp[i].equals("C")) {
						Cloud newCloud = new Cloud();
						newCloud.col = i;
						newCloud.row = numRows;
						newCloud.charName = temp[i].charAt(0);
						blocks.add(newCloud);
					}
					if(temp[i].equals("B")) {
						Castle newCastle = new Castle();
						newCastle.col = i;
						newCastle.row = numRows;
						newCastle.charName = temp[i].charAt(0);
						blocks.add(newCastle);
					}
					if(temp[i].equals("T")) {
						TacoLauncher newLauncher = new TacoLauncher();
						newLauncher.col = i;
						newLauncher.row = numRows;
						newLauncher.charName = temp[i].charAt(0);
						blocks.add(newLauncher);
					}
					if(temp[i].equals("G")) {
						Grass newGrass = new Grass();
						newGrass.col = i;
						newGrass.row = numRows;
						newGrass.charName = temp[i].charAt(0);
						blocks.add(newGrass);
					}
					if(temp[i].equals("W")) {
						Air newBlank = new Air();
						newBlank.col = i;
						newBlank.row = numRows;
						newBlank.charName = temp[i].charAt(0);
						blocks.add(newBlank);
					}
				}
				numRows++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("config.txt cannot be found. Please add config.txt to the list and try again.");
		}
	}
	
	public void loadLegend() {
		try {
			FileReader reader = new FileReader("legend.txt");
			Scanner in = new Scanner(reader);
			String delimiter = ", ";
			String[] temp = null;
			
			char roomKey = 0;
			String roomName = null;
			
			while(in.hasNextLine()) {
				String line = in.nextLine();
				temp = line.split(delimiter);
				for(int i = 0; i < temp.length; i++) {
					if(i % 2 == 0) {
						char tempKey = temp[i].charAt(0);
						roomKey = tempKey;
					} else {
						roomName = temp[i];
					}
				}
				legend.put(roomKey, roomName);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("legend.txt cannot be found. Please add legend.txt to the list and try again.");
		}
	}

	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	
	public static void main(String[] args) {
		FProjMain newProj = new FProjMain();
		System.out.println("Size of blocks array: " + newProj.blocks.size());
		for(Block block : newProj.blocks)
			System.out.println("Block name: " + newProj.legend.get(block.charName) + " --- " + "Column: " + block.getCol() + " Row: " + block.getRow());

	}

}
