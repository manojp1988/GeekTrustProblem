package geekTrust.set2.problem1.domain;

import java.util.LinkedHashSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Nation.
 */
public class Nation {
	
	/** The batallions. */
	private final Set<Batallion> batallions = new LinkedHashSet<>();

	/**
	 * Gets the batallions.
	 *
	 * @return the batallions
	 */
	public Set<Batallion> getBatallions() {
		return batallions;
	}

	/**
	 * Adds the to batallions.
	 *
	 * @param batallion the batallion
	 */
	public void addToBatallions(Batallion batallion) {
		batallions.add(batallion);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Nation [batallions=" + batallions + "]";
	}

}
