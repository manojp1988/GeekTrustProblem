package geekTrust.set2.problem1.war.rule;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.domain.Nation;

import java.util.Map;

public abstract class Rule {
	
	protected Nation goodNation;
	protected Nation badNation;
	protected boolean proceed;
	
	public Rule(Nation goodNation2, Nation badNation2){
		this.goodNation = goodNation2;
		this.badNation = badNation2;
	}
	abstract  public Batallion execute(Batallion b1,Map<String , Batallion>neededBatalloinToWin);
	
	abstract  public boolean proceed();
	 
	public boolean matchBatallions(Batallion requiredBatallion,Map<String, Batallion> neededBatallionToWin){

		for (Batallion goodBatallion : goodNation.getBatallions()){
			if (goodBatallion.equals(requiredBatallion)){
				if (goodBatallion.getCount() >= requiredBatallion.getCount()){
					if(neededBatallionToWin.containsKey(requiredBatallion.getBatallionType().name())){

						Batallion temp = neededBatallionToWin.get(requiredBatallion.getBatallionType().name());
						temp.setCount(temp.getCount()+requiredBatallion.getCount());
						neededBatallionToWin.put(requiredBatallion.getBatallionType().name(), temp);
					}else{
						neededBatallionToWin.put(requiredBatallion.getBatallionType().name(),Batallion.copyBatallion(requiredBatallion));

					}
					goodBatallion.setCount(goodBatallion.getCount() - requiredBatallion.getCount());
					requiredBatallion.setCount(0);
					return true;
				}else{
					if (neededBatallionToWin.containsKey(requiredBatallion.getBatallionType().name())){

						Batallion temp = neededBatallionToWin.get(requiredBatallion.getBatallionType().name());
						temp.setCount(temp.getCount() + goodBatallion.getCount());
						neededBatallionToWin.put(requiredBatallion.getBatallionType().name(), temp);

					}else{
						neededBatallionToWin.put(requiredBatallion.getBatallionType().name(),Batallion.copyBatallion(goodBatallion));
					}
					requiredBatallion.setCount(requiredBatallion.getCount() - goodBatallion.getCount());
					goodBatallion.setCount(0);
					return false;
				}
			}
		}
		return false;
}
}

				