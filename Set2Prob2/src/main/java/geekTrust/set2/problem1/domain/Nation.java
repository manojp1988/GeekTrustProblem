package geekTrust.set2.problem1.domain;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Nation {
	
	private final Set<Batallion> batallions = new TreeSet<>(new Comparator<Batallion>() {
		@Override
		public int compare(Batallion b1, Batallion b2) {
			return b1.getBatallionType().getPowerLevel() - b2.getBatallionType().getPowerLevel();
		}
	});

	public Set<Batallion> getBatallions() {
		return batallions;
	}

	public void addToBatallions(Batallion batallion) {
		batallions.add(batallion);
	}

	@Override
	public String toString() {
		return "Nation [batallions=" + batallions + "]";
	}

}
