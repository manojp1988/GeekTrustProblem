package geekTrust.set2.problem1.app;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.domain.Nation;
import geekTrust.set2.problem1.domain.Type;
import geekTrust.set2.problem1.war.War;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class Application.
 */
public class Application {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		DataSetup setup = new DataSetup();
		Nation lingaburu = new Nation();
		Nation falicornia = new Nation();
		
		setup.setUpArmies(lingaburu, falicornia);
		War war = setup.declareWar(lingaburu, falicornia);

		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		scanner.close();

		Map<String, Integer> deployableBatallions = war.getBatallionRequirements(getInput(inputString));
		printResult(war, deployableBatallions);
		
		

	}

	/**
	 * Gets the input.
	 *
	 * @param input
	 *            the input
	 * @return the input
	 */
	private static Set<Batallion> getInput(String input) {

		Set<Batallion> batallions = new LinkedHashSet<>();
		String[] fristLevelStrings = input.split(" ");
		for (String string : fristLevelStrings) {
			Pattern pattern = Pattern.compile("[0-9]+|[A-Z]+");
			Matcher matcher = pattern.matcher(string);
			matcher.find();
			int count = Integer.valueOf(matcher.group());

			matcher.find();
			String army = matcher.group();

			switch (army) {
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
	 * @param war
	 *            the war
	 * @param deployableBatallions
	 *            the deployable batallions
	 */
	private static void printResult(War war, Map<String, Integer> deployableBatallions) {
		for (String key : deployableBatallions.keySet()) {
			int count = deployableBatallions.get(key);
			System.out.printf("%d%s",count,key.charAt(0));
			System.out.print(" ");

		}
		System.out.println(": " + war.getWarStatus());
	}

}
