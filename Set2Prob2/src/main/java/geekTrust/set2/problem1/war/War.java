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

		for (Batallion badBatallion : badBatallions) {
			boolean doesBatallionMatches = false;
			for (Rule rule : rules) {
				int i=0;
				do{
				Batallion requiredBatallion = rule.execute(badBatallion);
				if (matchBatallions(requiredBatallion, neededBatallionToWin)) {
					doesBatallionMatches = true;
					break;
				}
				badBatallion = requiredBatallion;
				}while(badBatallion.getCount()>0 && rule.isIterable() && i++ <= Type.values().length);
				
				if(doesBatallionMatches)break;
			}
			if (!doesBatallionMatches) {
				status = "LOSES";
			}
		}

		return neededBatallionToWin;
	}

	public boolean matchBatallions(Batallion requiredBatallion,
			Map<String, Batallion> neededBatallionToWin) {

		for (Batallion goodBatallion : goodNation.getBatallions()) {
			if (goodBatallion.equals(requiredBatallion)) {
				if (goodBatallion.getCount() >= requiredBatallion.getCount()) {
					if (neededBatallionToWin.containsKey(requiredBatallion
							.getBatallionType().name())) {
						Batallion temp = neededBatallionToWin
								.get(requiredBatallion.getBatallionType()
										.name());
						temp.setCount(temp.getCount()
								+ requiredBatallion.getCount());
						neededBatallionToWin.put(requiredBatallion
								.getBatallionType().name(), temp);
					} else {
						neededBatallionToWin.put(requiredBatallion
								.getBatallionType().name(), Batallion
								.copyBatallion(requiredBatallion));
					}
					goodBatallion.setCount(goodBatallion.getCount()
							- requiredBatallion.getCount());
					requiredBatallion.setCount(0);
					return true;
				} else {
					if (neededBatallionToWin.containsKey(requiredBatallion
							.getBatallionType().name())) {
						Batallion temp = neededBatallionToWin
								.get(requiredBatallion.getBatallionType()
										.name());
						temp.setCount(temp.getCount()
								+ goodBatallion.getCount());
						neededBatallionToWin.put(requiredBatallion
								.getBatallionType().name(), temp);
					} else {
						neededBatallionToWin.put(requiredBatallion
								.getBatallionType().name(), Batallion
								.copyBatallion(goodBatallion));
					}
					requiredBatallion.setCount(requiredBatallion.getCount()
							- goodBatallion.getCount());
					goodBatallion.setCount(0);
					return false;
				}
			}
		}
		return false;

	}

	public String getWarStatus() {
		return status;
	}

}
