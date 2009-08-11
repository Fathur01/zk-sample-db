package de.forsthaus.backend.model;

// Generated 31.01.2009 22:31:49 by Hibernate Tools 3.2.2.GA

/**
 * SecGroupright generated by hbm2java
 */
public class SecGroupright implements java.io.Serializable {

	private static final long serialVersionUID = 9206102047641563556L;

	private long griId = Long.MIN_VALUE;
	private int version;
	private SecGroup secGroup;
	private SecRight secRight;

	public boolean isNew() {
		return (getGriId() == Long.MIN_VALUE);
	}

	public SecGroupright() {
	}

	public SecGroupright(long griId) {
		this.griId = griId;
	}

	public SecGroupright(long griId, SecGroup secGroup, SecRight secRight) {
		this.griId = griId;
		this.secGroup = secGroup;
		this.secRight = secRight;
	}

	public long getGriId() {
		return this.griId;
	}

	public void setGriId(long griId) {
		this.griId = griId;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public SecGroup getSecGroup() {
		return this.secGroup;
	}

	public void setSecGroup(SecGroup secGroup) {
		this.secGroup = secGroup;
	}

	public SecRight getSecRight() {
		return this.secRight;
	}

	public void setSecRight(SecRight secRight) {
		this.secRight = secRight;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(getGriId()).hashCode();
	}

	public boolean equals(SecGroupright secGroupright) {
		return getGriId() == secGroupright.getGriId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecGroupright) {
			SecGroupright secGroupright = (SecGroupright) obj;
			return equals(secGroupright);
		}

		return false;
	}

}
