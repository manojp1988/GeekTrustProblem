package geekTrust.set2.problem1.war.rule;

import geekTrust.set2.problem1.domain.Batallion;

public interface Rule {

	Batallion execute(Batallion b1);
	boolean isIterable();

}
