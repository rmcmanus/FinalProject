package FProj;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class TacoLauncherTest {
	public static FProjMain main;
	public static TacoLauncher tacoLauncher;
	Block testBlock;
	@BeforeClass
	public static void setUp() {
		main = new FProjMain();
		tacoLauncher = new TacoLauncher();
	}
	
	@Test
	public void testCastleLocation() {
		//Test top left corner
		Assert.assertTrue(main.getBlocks().get(197).isCastleBlock());
		//Test top middle edge
		Assert.assertTrue(main.getBlocks().get(202).isCastleBlock());
		//Test top right corner
		Assert.assertTrue(main.getBlocks().get(207).isCastleBlock());
		//Test random top edge block
		Assert.assertTrue(main.getBlocks().get(283).isCastleBlock());
		//Test bottom right corner
		Assert.assertTrue(main.getBlocks().get(441).isCastleBlock());
		//Test bottom left corner
		Assert.assertTrue(main.getBlocks().get(431).isCastleBlock());
		//Test random internal block
		Assert.assertTrue(main.getBlocks().get(356).isCastleBlock());
	}
	
	@Test
	public void testTacoLauncherLocation() {
		//Test launcher location
		Assert.assertTrue(main.getBlocks().get(366).isLauncherBlock());
		Assert.assertTrue(main.getBlocks().get(392).isLauncherBlock());
		Assert.assertTrue(main.getBlocks().get(418).isLauncherBlock());
	}
	
	@Test
	public void testGrassLocation() {
		//Test ends of grass
		Assert.assertTrue(main.getBlocks().get(442).isGrassBlock());
		Assert.assertTrue(main.getBlocks().get(467).isGrassBlock());
	}
	
	@Test
	public void testCloudLocation() {
		//Test cloud locations
		Assert.assertTrue(main.getBlocks().get(2).isCloudBlock());
		Assert.assertTrue(main.getBlocks().get(84).isCloudBlock());
		Assert.assertTrue(main.getBlocks().get(106).isCloudBlock());
	}
	
	@Test
	public void testLauncherChange() {
		tacoLauncher.changeLauncher(25, 12);
		//Test that changeLauncher changed angle
		Assert.assertEquals(25, tacoLauncher.getAngle());
		//Test that changeLauncher changed velocity
		Assert.assertEquals(12, tacoLauncher.getVelocity());
		
		tacoLauncher.changeLauncher(90, 5);
		//Test that changeLauncher changed angle
		Assert.assertEquals(90, tacoLauncher.getAngle());
		//Test that changeLauncher changed velocity
		Assert.assertEquals(5, tacoLauncher.getVelocity());
	}
	
	@Test
	public void testLaunch() {
		tacoLauncher.throwProjectile();
		//set position of projectile
		
		//test some point on path
		
		//test 2nd point on path
		
		//test y = max
		
		//test y=0, or 'hits' ground
	}

}
