package geekTrust.set2.problem1.domain;

public enum Type {
	HORSE(1), ELEPHANT(2), TANK(3), SLING_GUN(4);

	private int powerLevel;

	Type(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	public int getPowerLevel() {
		return powerLevel;
	}
	
}
