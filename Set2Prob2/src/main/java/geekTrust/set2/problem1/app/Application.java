package geekTrust.set2.problem1.app;

import geekTrust.set2.problem1.domain.Batallion;
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
		setup.setUpArmies();
		War war = setup.declareWar();

		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		scanner.close();

		Map<String, Batallion> deployableBatallions = war.getBatallionRequirements(getInput(inputString));
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
	private static void printResult(War war,
			Map<String, Batallion> deployableBatallions) {
		for (Batallion b : deployableBatallions.values()) {
			System.out.print(b);
			System.out.print(" ");

		}
		System.out.println(": " + war.getWarStatus());
	}

}
