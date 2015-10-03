package geekTrust.set2.problem1.domain;

public class Batallion {

	private Type batallionType;
	private int count;

	public Batallion(Type batallion, int count) {
		super();
		this.batallionType = batallion;
		this.count = count;
	}

	public Type getBatallionType() {
		return batallionType;
	}

	public int getCount() {
		return count;
	}

	
	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((batallionType == null) ? 0 : batallionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batallion other = (Batallion) obj;
		if (batallionType != other.batallionType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return count + "" + batallionType.name().charAt(0);
	}

	public static Batallion copyBatallion(Batallion batallion) {
		return new Batallion(batallion.getBatallionType(),
				batallion.getCount());
	}

}
