package geekTrust.set2.problem1.war.rule;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.domain.Nation;

public class SubstitutionRule implements Rule {

	Nation goodNation;
	
	public SubstitutionRule(Nation goodNation) {
		this.goodNation = goodNation;
	}

	@Override
	public Batallion execute(Batallion b1) {
		for (Batallion goodBatallion : goodNation.getBatallions()) {
			
			if(goodBatallion.getCount()<=0)continue;
			
			int prevPowerLevel = b1.getBatallionType().getPowerLevel() - 1;
			int nextPowerLevel = b1.getBatallionType().getPowerLevel() + 1;
			if (goodBatallion.getBatallionType().getPowerLevel() == prevPowerLevel) {
				return new Batallion(goodBatallion.getBatallionType(),
						2 * b1.getCount());
			} else if (goodBatallion.getBatallionType().getPowerLevel() == nextPowerLevel) {
				return new Batallion(goodBatallion.getBatallionType(),
						(int)Math.ceil(b1.getCount()/2));
			}
		}
		return null;
	}

	@Override
	public boolean isIterable() {
		// TODO Auto-generated method stub
		return true;
	}
}
