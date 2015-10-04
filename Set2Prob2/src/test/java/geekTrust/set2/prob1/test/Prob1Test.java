package geekTrust.set2.prob1.test;

import geekTrust.set2.problem1.domain.Batallion;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class Prob1Test.
 */
public class Prob1Test extends BaseTestClass {
	
	
	   
	 /**
 	 * Data provider method.
 	 *
 	 * @return the object[][]
 	 */
 	@DataProvider(name = "data-provider")
	    public Object[][] dataProviderMethod() {
	        return new Object[][] { { "100H 101E 20T 5S", new int[]{52, 50, 10, 3}, "WINS" },
	        						{ "150H 96E 26T 8S", new int[]{75, 50, 10, 5}, "WINS" },
	        						{ "250H 50E 20T 15S", new int[]{100, 38, 10, 5}, "LOSES" },
	        						{"100H 50E",new int[] {50, 25},"WINS"},
	        					  };
	    }
	
	/**
	 * Test1.
	 *
	 * @param input the input
	 * @param expectedOpts the expected opts
	 * @param warStatus the war status
	 */
	@Test(dataProvider = "data-provider")
	public void test1(String input , int[] expectedOpts, String warStatus){
		
		Map<String,Batallion> deployableBatallions = war.getBatallionRequirements(getInput(input));
		printResult(war, deployableBatallions);
		
		Assert.assertEquals(war.getWarStatus(),warStatus);
		for(int i=0;i<expectedOpts.length;i++){
			switch(i){
			case 0:
				assertCheck("HORSE",deployableBatallions,expectedOpts[0]);
				break;
			case 1:
				assertCheck("ELEPHANT",deployableBatallions,expectedOpts[1]);
				break;
			case 2:
				assertCheck("TANK",deployableBatallions,expectedOpts[2]);
				break;
			case 3:
				assertCheck("SLING_GUN",deployableBatallions,expectedOpts[3]);
				break;
			}
				
				
			}
		}
		
	   
	/**
	 * Assert check.
	 *
	 * @param Key the key
	 * @param deployableBatallions the deployable batallions
	 * @param Count the count
	 */
	private void assertCheck( String Key,Map<String,Batallion>deployableBatallions,int Count) {
		if(deployableBatallions.containsKey(Key)){
			Assert.assertEquals(deployableBatallions.get(Key).getCount(),Count);
		
	}
	}	
	
	}

	


