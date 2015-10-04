package geekTrust.set2.problem1.app;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.domain.Nation;
import geekTrust.set2.problem1.domain.Type;
import geekTrust.set2.problem1.war.War;
import geekTrust.set2.problem1.war.rule.PowerRule;
import geekTrust.set2.problem1.war.rule.Rule;
import geekTrust.set2.problem1.war.rule.SubstitutionRule;

/**
 * The Class SetUp.
 */
public class DataSetup {


	/**
	 * Gets the war.
	 *
	 * @return the war
	 */
	public War declareWar(Nation lingaburu, Nation falicornia) {
		War war = new War();

		Rule powerRule = new PowerRule(2, lingaburu, falicornia);
		Rule substitutionRule = new SubstitutionRule(lingaburu, falicornia);
		war.addRulesToWar(powerRule);
		war.addRulesToWar(substitutionRule);
		return war;
	}

	/**
	 * Sets the up armies.
	 */
	public void setUpArmies(Nation lingaburu, Nation falicornia) {
		lingaburu.addToBatallions(new Batallion(Type.HORSE, 100));
		lingaburu.addToBatallions(new Batallion(Type.ELEPHANT, 50));
		lingaburu.addToBatallions(new Batallion(Type.TANK, 10));
		lingaburu.addToBatallions(new Batallion(Type.SLING_GUN, 5));

		falicornia.addToBatallions(new Batallion(Type.HORSE, 100));
		falicornia.addToBatallions(new Batallion(Type.ELEPHANT, 50));
		falicornia.addToBatallions(new Batallion(Type.TANK, 10));
		falicornia.addToBatallions(new Batallion(Type.SLING_GUN, 5));
	}
}
