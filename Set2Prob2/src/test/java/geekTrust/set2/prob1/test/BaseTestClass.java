package geekTrust.set2.prob1.test;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.domain.Nation;
import geekTrust.set2.problem1.domain.Type;
import geekTrust.set2.problem1.war.War;
import geekTrust.set2.problem1.war.rule.PowerRule;
import geekTrust.set2.problem1.war.rule.Rule;
import geekTrust.set2.problem1.war.rule.SubstitutionRule;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.BeforeMethod;

/**
 * The Class BaseTestClass.
 */
public class  BaseTestClass {

	/** The war. */
	War war = null;
	
	/**
	 * Setup.
	 */
	@BeforeMethod
	public void Setup(){
		Nation lingaburu = new Nation();
		Nation falicornia = new Nation();
		
		lingaburu.addToBatallions(new Batallion(Type.HORSE, 100));
		lingaburu.addToBatallions(new Batallion(Type.ELEPHANT, 50));
		lingaburu.addToBatallions(new Batallion(Type.TANK, 10));
		lingaburu.addToBatallions(new Batallion(Type.SLING_GUN, 5));
		
		falicornia.addToBatallions(new Batallion(Type.HORSE, 300));
		falicornia.addToBatallions(new Batallion(Type.ELEPHANT, 200));
		falicornia.addToBatallions(new Batallion(Type.TANK, 40));
		falicornia.addToBatallions(new Batallion(Type.SLING_GUN, 20));
		
		war = new War();
		
		Rule powerRule = new PowerRule(2, lingaburu,falicornia);
		Rule substitutionRule = new SubstitutionRule(lingaburu,falicornia);
		war.addRulesToWar(powerRule);
		war.addRulesToWar(substitutionRule);
	}
	
	/**
	 * Gets the input.
	 *
	 * @param input the input
	 * @return the input
	 */
	protected Set<Batallion> getInput(String input){
		
		Set<Batallion> batallions = new LinkedHashSet<>();
		String[]firstLevel = input.split(" ");
		for(String str : firstLevel){
			Pattern pattern = Pattern.compile("[0-9]+|[A-Z]+");
			Matcher matcher = pattern.matcher(str);
			matcher.find();
			int count = Integer.valueOf(matcher.group());

			matcher.find();
			String army = matcher.group();
			
			switch(army){
			case "H":
					batallions.add(new Batallion(Type.HORSE, count));
					break;
			case "E":
					batallions.add(new Batallion(Type.ELEPHANT, count));
					break;
			case "T":
					batallions.add(new Batallion(Type.TANK, count));
					break;
			case "S":
					batallions.add(new Batallion(Type.SLING_GUN, count));
					break;
					
			}
			
		}
		
		return batallions;
		
	}
	
	/**
	 * Prints the result.
	 *
	 * @param war the war
	 * @param deployableBatallions the deployable batallions
	 */
	protected static void printResult(War war, Map<String, Integer> deployableBatallions) {
		for (String key : deployableBatallions.keySet()) {
			int count = deployableBatallions.get(key);
			System.out.printf("%d%s ",count,key.charAt(0));
		}
		System.out.println(": " + war.getWarStatus());
	}
}