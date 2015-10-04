package geekTrust.set2.problem1.domain;

// TODO: Auto-generated Javadoc
/**
 * The Class Batallion.
 */
public class Batallion {

	/** The batallion type. */
	private Type batallionType;
	
	/** The count. */
	private int count;

	/**
	 * Instantiates a new batallion.
	 *
	 * @param batallion the batallion
	 * @param count the count
	 */
	public Batallion(Type batallion, int count) {
		super();
		this.batallionType = batallion;
		this.count = count;
	}

	/**
	 * Gets the batallion type.
	 *
	 * @return the batallion type
	 */
	public Type getBatallionType() {
		return batallionType;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	
	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(int count) {
		this.count = count;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((batallionType == null) ? 0 : batallionType.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return count + "" + batallionType.name().charAt(0);
	}

	

}
