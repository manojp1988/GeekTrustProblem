package geekTrust.set2.problem1.war.rule;

import geekTrust.set2.problem1.domain.Batallion;

public class PowerRule implements Rule {

	private int power;

	public PowerRule(int power) {
		this.power = power;
	}

	@Override
	public Batallion execute(Batallion b1) {
		return new Batallion(b1.getBatallionType(), (int) Math.ceil(b1
				.getCount() / (double)power));
	}

	@Override
	public boolean isIterable() {
		// TODO Auto-generated method stub
		return false;
	}
}
