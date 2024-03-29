package FProj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FProjMain extends JPanel {

	ArrayList<Block> blocks = new ArrayList<Block>();
	Map<Character, String> legend = new TreeMap<Character, String>();
	Projectile projectile;
	TacoLauncher launcher;
	Trajectory trajectory;
	int numRows = 0, numCols=0;
	public static FProjMain globalMain;
	int castleBlockCounter = 0;

	Timer timer = new Timer(30, (new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			projectile.calcStep();
			collide(projectile);
			repaint();
			if((projectile.getY() >= (numRows - 1.5) * Block.CELLSIZE) || (projectile.getX() > (numCols + 1) * Block.CELLSIZE)) {
				projectile = new Projectile(0, 0, 0);
				timer.stop();
			}
		}
	}
	));
	
	public FProjMain() {
		loadLegend();
		loadMapFromFile();
		globalMain = this;
	}
	
	public static FProjMain getMain() {
		return globalMain;
	}

	public void collide(Projectile p){
		int x = p.getX()/25;
		int y = p.getY()/25;
		if(y > 0) {
			if(blocks.get(getIndex(x,y)).isCastleBlock()){
				castleBlockCounter--;
				Block temp = new Air();
				temp.col = x;
				temp.row = y;
				int tempIndex = getIndex(x, y);
				blocks.set(tempIndex, temp);
				timer.stop();
				//Readjust projectile back to launcher
				projectile = new Projectile(0, 0, 0);
				timer.stop();
			}
		}
		else {
			
		}
	}

	public int getIndex(int x, int y){
		return y*numCols + x;
	}

	public void loadMapFromFile() {
		try {
			FileReader inputReader = new FileReader("configNew.csv");
			Scanner in = new Scanner(inputReader);
			String delimiter = ",";

			while(in.hasNextLine()) {
				String line = in.nextLine();
				String[] temp = line.split(delimiter);
				numCols = temp.length;
				for(int i = 0; i < temp.length; i++) {
					if(temp[i].equals("C")) {
						Cloud newCloud = new Cloud();
						newCloud.col = i;
						newCloud.row = numRows;
						newCloud.charName = temp[i].charAt(0);
						blocks.add(newCloud);
					}
					if(temp[i].equals("B")) {
						castleBlockCounter++;
						Castle newCastle = new Castle();
						newCastle.col = i;
						newCastle.row = numRows;
						newCastle.charName = temp[i].charAt(0);
						blocks.add(newCastle);
					}
					if(temp[i].equals("T")) {
						launcher = new TacoLauncher();
						launcher.col = i;
						launcher.row = numRows;
						launcher.charName = temp[i].charAt(0);
						blocks.add(launcher);
						Projectile.initialX = i * Block.CELLSIZE;
						Projectile.initialY = numRows * Block.CELLSIZE;
						projectile = new Projectile(0, 0, 0);
						trajectory = new Trajectory();

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

	public void fly() {
		projectile = launcher.throwProjectile();
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Block blo : blocks) {
			blo.draw(g);
		}
		if(!timer.isRunning() && TacoLauncher.velocity > 0 && TacoLauncher.angle > 0)
			trajectory.draw(g);
		projectile.draw(g);
	}

}
