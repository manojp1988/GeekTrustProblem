package geekTrust.set2.problem1.domain;

/**
 * The Enum Type.
 */
public enum Type {

	HORSE(1), ELEPHANT(2), TANK(3), SLING_GUN(4);

	/** The power level. */
	private int powerLevel;

	/**
	 * Instantiates a new type.
	 *
	 * @param powerLevel
	 *            the power level
	 */
	Type(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	/**
	 * Gets the power level.
	 *
	 * @return the power level
	 */
	public int getPowerLevel() {
		return powerLevel;
	}

}
