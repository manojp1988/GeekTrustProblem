package geekTrust.set2.problem1.war;

import geekTrust.set2.problem1.domain.Batallion;
import geekTrust.set2.problem1.domain.Nation;
import geekTrust.set2.problem1.domain.Type;
import geekTrust.set2.problem1.war.rule.Rule;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.management.modelmbean.RequiredModelMBean;

public class War {

	private String status = "WINS";
	private Nation goodNation;
	private Nation badNation;
	private Set<Rule> rules = new LinkedHashSet<>();

	public War(Nation goodNation, Nation badNation) {
		this.goodNation = goodNation;
		this.badNation = badNation;
	}

	public void addRulesToWar(Rule rule) {
		rules.add(rule);
	}

	public Map<String, Batallion> getBatallionRequirements(
			Set<Batallion> badBatallions) {

		Map<String, Batallion> neededBatallionToWin = new HashMap<>();
		Batallion requiredBatallion = null;

		for (Batallion badBatallion : badBatallions) {
			for(Rule rule:rules){
				badBatallion = rule.execute(badBatallion,neededBatallionToWin);
				requiredBatallion = badBatallion;
				if(!rule.proceed()){
					break;
				}
						
			}
			
			
		}
		if(requiredBatallion!=null && requiredBatallion.getCount()>0)
			status = "LOSES";
       return neededBatallionToWin;
	}	
	
	public String getWarStatus() {
		return status;
	}

}
