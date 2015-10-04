package geekTrust.set2.problem1.war.rule;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.domain.Nation;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class PowerRule.
 */
public class PowerRule extends Rule {

	/** The power. */
	private int power;

	/**
	 * Instantiates a new power rule.
	 *
	 * @param power the power
	 * @param goodNation the good nation
	 * @param badNation the bad nation
	 */
	public PowerRule(int power, Nation goodNation,Nation badNation) {
		super(goodNation,badNation);	
		this.power = power;
	}

	/* (non-Javadoc)
	 * @see geekTrust.set2.problem1.war.rule.Rule#execute(geekTrust.set2.problem1.domain.Batallion, java.util.Map)
	 */
	@Override
	public Batallion execute(Batallion b1,Map<String , Integer>neededBatallionToWin) {

		Batallion reguiredBatallion = new Batallion(b1.getBatallionType(), (int) Math.ceil(b1.getCount() /(double) power));
		matchBatallions(reguiredBatallion,neededBatallionToWin);
		if(reguiredBatallion.getCount()>0){
			proceed = true;
		}else{
			proceed = false;
		}
		return reguiredBatallion;
	}
	
	/* (non-Javadoc)
	 * @see geekTrust.set2.problem1.war.rule.Rule#proceed()
	 */
	@Override
	public boolean proceed(){
		return proceed;

	}

	
}
	
		
		
		
		
		
		
