package geekTrust.set2.problem1.domain;

// TODO: Auto-generated Javadoc
/**
 * The Enum Type.
 */
public enum Type {
	
	/** The horse. */
	HORSE(1), 
 /** The elephant. */
 ELEPHANT(2), 
 /** The tank. */
 TANK(3), 
 /** The sling gun. */
 SLING_GUN(4);

	/** The power level. */
	private int powerLevel;

	/**
	 * Instantiates a new type.
	 *
	 * @param powerLevel the power level
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
