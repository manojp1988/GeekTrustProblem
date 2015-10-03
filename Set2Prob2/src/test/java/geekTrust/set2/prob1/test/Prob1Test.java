package geekTrust.set2.prob1.test;

import geekTrust.set2.problem1.domain.Batallion;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Prob1Test extends BaseTestClass {
	
	
	/* @DataProvider(name = "data-provider")
	    public Object[][] dataProviderMethod() {
	        return new Object[][] { { "100H 50E", new Object[]{new Integer(50), new Integer(25), "WINS"} },
	        						{ "1000H 500E", new Object[]{new Integer(100), new Integer(50), "LOSES"} },
	        						{ "300H 200E", new Object[]{new Integer(100), new Integer(50), "LOSES"} },
	        						{ "3H 2E", new Object[]{new Integer(2), new Integer(1), "WINS"} },
	        						{ "200H 100E", new Object[]{new Integer(100), new Integer(50), "WINS"} },
	        						{ "100H 50E", new Object[]{new Integer(50), new Integer(25), "WINS"} },
	        						{ "100H 100E", new Object[]{new Integer(50), new Integer(50), "WINS"} },
	        						{ "200H 101E", new Object[]{new Integer(100), new Integer(50), "LOSES"} },
	        						{ "300H 10E", new Object[]{new Integer(100), new Integer(30), "WINS"} },
	        					  };
	    }*/
	
	 @DataProvider(name = "data-provider")
	    public Object[][] dataProviderMethod() {
	        return new Object[][] { //{ "100H 101E 20T 5S", new int[]{52, 50, 10, 3}, "WINS" },
	        						{ "150H 96E 26T 8S", new int[]{75, 50, 10, 5}, "WINS" },
	        						//{ "250H 50E 20T 15S", new int[]{100, 38, 10, 5}, "LOSES" },
	        					  };
	    }
	
	@Test(dataProvider = "data-provider")
	public void test1(String input , int[] expectedOpts, String warStatus){
		
		Map<String,Batallion> deployableBatallions = war.getBatallionRequirements(getInput(input));
		printResult(war, deployableBatallions);
		
		Assert.assertEquals( deployableBatallions.get("HORSE").getCount(), expectedOpts[0]);
		Assert.assertEquals( deployableBatallions.get("ELEPHANT").getCount(), expectedOpts[1]);
		Assert.assertEquals( deployableBatallions.get("TANK").getCount(), expectedOpts[2]);
		Assert.assertEquals( deployableBatallions.get("SLING_GUN").getCount(), expectedOpts[3]);
		Assert.assertEquals( war.getWarStatus(),warStatus);
		
		
	}

	

}
