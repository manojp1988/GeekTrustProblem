package geekTrust.set2.problem1.war.rule;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.domain.Nation;

import java.util.Map;
import java.util.regex.Matcher;

public class SubstitutionRule extends Rule {


	
	public SubstitutionRule(Nation goodNation,Nation badNation) {
		super(goodNation,badNation);
	}

	@Override
	public Batallion execute(Batallion b1, Map<String,Batallion> neededBatallionToWin) {
		Batallion requiredBatallion =b1;
		for (Batallion goodBatallion : goodNation.getBatallions()) {
			
			if(goodBatallion.getCount()<=0)continue;
			
			int prevPowerLevel = b1.getBatallionType().getPowerLevel() - 1;
			int nextPowerLevel = b1.getBatallionType().getPowerLevel() + 1;
			if (goodBatallion.getBatallionType().getPowerLevel() == prevPowerLevel) {
				requiredBatallion = new Batallion(goodBatallion.getBatallionType(),2 * b1.getCount());
				
			} else if (goodBatallion.getBatallionType().getPowerLevel() == nextPowerLevel) {
				 requiredBatallion =new Batallion(goodBatallion.getBatallionType(),
						(int)Math.ceil(b1.getCount()/2.0));
			}else{
				continue;
			}
			matchBatallions(requiredBatallion, neededBatallionToWin);
			
			if(requiredBatallion.getCount() <=0){
				break;
			}else{
				if(requiredBatallion.getBatallionType().getPowerLevel() < b1.getBatallionType().getPowerLevel()){
					b1.setCount((int)Math.ceil(requiredBatallion.getCount()/2.0));
				}else{
					break;
				}
			}
		}
		if(requiredBatallion.getCount()>0){
			proceed = true;
		}
		return requiredBatallion;
	}

	@Override
	public boolean proceed() {
		// TODO Auto-generated method stub
		return false;
	}
}




