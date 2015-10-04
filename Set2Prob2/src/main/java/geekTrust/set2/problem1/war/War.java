package geekTrust.set2.problem1.war;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.war.rule.Rule;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * The Class War.
 */
public class War {

	/** The status. */
	private String status;
	
	/** The rules. */
	private Set<Rule> rules = new LinkedHashSet<>();

	/**
	 * Adds the rules to war.
	 *
	 * @param rule the rule
	 */
	public void addRulesToWar(Rule rule) {
		rules.add(rule);
	}

	/**
	 * Gets the batallion requirements.
	 *
	 * @param badBatallions the bad batallions
	 * @return the batallion requirements
	 */
	public Map<String, Integer> getBatallionRequirements(
			Set<Batallion> badBatallions) {

		Map<String, Integer> neededBatallionToWin = new HashMap<>();
		Batallion requiredBatallion = null;

		for (Batallion badBatallion : badBatallions) {
			for (Rule rule : rules) {
				badBatallion = rule.execute(badBatallion, neededBatallionToWin);
				requiredBatallion = badBatallion;
				if (!rule.proceed()) {
					break;
				}
			}
		}
		if (requiredBatallion.getCount() > 0) {
			status = "LOSES";
		}else {
			status = "WINS";
		}
		return neededBatallionToWin;
	}

	/**
	 * Gets the war status.
	 *
	 * @return the war status
	 */
	public String getWarStatus() {
		return status;
	}

}
