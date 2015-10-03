package geekTrust.set2.problem1.war.rule;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.domain.Nation;

import java.security.PublicKey;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

public class PowerRule extends Rule {

	private int power;

	public PowerRule(int power, Nation goodNation,Nation badNation) {
		super(goodNation,badNation);	
		this.power = power;
	}

	@Override
	public Batallion execute(Batallion b1,Map<String , Batallion>neededBatallionToWin) {

		Batallion reguiredBatallion = new Batallion(b1.getBatallionType(), (int) Math.ceil(b1.getCount() /(double) power));
		matchBatallions(reguiredBatallion,neededBatallionToWin);
		if(reguiredBatallion.getCount()>0){
			proceed = true;
		}else{
			proceed = false;
		}
		return reguiredBatallion;
	}
	@Override
	public boolean proceed(){
		return proceed;

	}

	
}
	
		
		
		
		
		
		
