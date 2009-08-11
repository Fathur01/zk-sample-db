package de.forsthaus.backend.model;

// Generated 18.10.2008 19:00:08 by Hibernate Tools 3.2.2.GA

/**
 * Nextidview generated by hbm2java
 */
public class Nextidview implements java.io.Serializable {

	private static final long serialVersionUID = 8543471037915270000L;

	private Long nextval;

	public Nextidview() {
	}

	public Nextidview(Long nextval) {
		this.nextval = nextval;
	}

	public Long getNextval() {
		return this.nextval;
	}

	public void setNextval(Long nextval) {
		this.nextval = nextval;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(getNextval()).hashCode();
	}

	public boolean equals(Nextidview nextidview) {
		return getNextval() == nextidview.getNextval();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Nextidview) {
			Nextidview nextidview = (Nextidview) obj;
			return equals(nextidview);
		}

		return false;
	}
}