package geekTrust.set2.problem1.war.rule;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.domain.Nation;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Rule.
 */
public abstract class Rule {

	/** The good nation. */
	protected Nation goodNation;
	
	/** The bad nation. */
	protected Nation badNation;
	
	/** The proceed. */
	protected boolean proceed;

	/**
	 * Instantiates a new rule.
	 *
	 * @param goodNation2 the good nation2
	 * @param badNation2 the bad nation2
	 */
	public Rule(Nation goodNation2, Nation badNation2) {
		this.goodNation = goodNation2;
		this.badNation = badNation2;
	}

	/**
	 * Execute.
	 *
	 * @param b1 the b1
	 * @param neededBatalloinToWin the needed batalloin to win
	 * @return the batallion
	 */
	abstract public Batallion execute(Batallion b1,
			Map<String, Batallion> neededBatalloinToWin);

	/**
	 * Proceed.
	 *
	 * @return true, if successful
	 */
	abstract public boolean proceed();

	/**
	 * Match batallions.
	 *
	 * @param requiredBatallion the required batallion
	 * @param neededBatallionToWin the needed batallion to win
	 * @return true, if successful
	 */
	public boolean matchBatallions(Batallion requiredBatallion,
			Map<String, Batallion> neededBatallionToWin) {

		for (Batallion goodBatallion : goodNation.getBatallions()) {
			if (goodBatallion.equals(requiredBatallion)) {
				if (goodBatallion.getCount() >= requiredBatallion.getCount()) {
					if (neededBatallionToWin.containsKey(requiredBatallion
							.getBatallionType().name())) {

						Batallion temp = neededBatallionToWin
								.get(requiredBatallion.getBatallionType()
										.name());
						temp.setCount(temp.getCount()
								+ requiredBatallion.getCount());
						neededBatallionToWin.put(requiredBatallion
								.getBatallionType().name(), temp);
					} else {
						neededBatallionToWin.put(requiredBatallion
								.getBatallionType().name(), copyBatallion(requiredBatallion));

					}
					goodBatallion.setCount(goodBatallion.getCount()
							- requiredBatallion.getCount());
					requiredBatallion.setCount(0);
					return true;
				} else {
					if (neededBatallionToWin.containsKey(requiredBatallion
							.getBatallionType().name())) {

						Batallion temp = neededBatallionToWin
								.get(requiredBatallion.getBatallionType()
										.name());
						temp.setCount(temp.getCount()
								+ goodBatallion.getCount());
						neededBatallionToWin.put(requiredBatallion
								.getBatallionType().name(), temp);

					} else {
						neededBatallionToWin.put(requiredBatallion
								.getBatallionType().name(), copyBatallion(goodBatallion));
					}
					requiredBatallion.setCount(requiredBatallion.getCount()
							- goodBatallion.getCount());
					goodBatallion.setCount(0);
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	 * Copy batallion.
	 *
	 * @param batallion the batallion
	 * @return the batallion
	 */
	public static Batallion copyBatallion(Batallion batallion) {
		return new Batallion(batallion.getBatallionType(),
				batallion.getCount());
	}
}
