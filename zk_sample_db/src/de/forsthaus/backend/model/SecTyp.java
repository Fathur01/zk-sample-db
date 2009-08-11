package de.forsthaus.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the types of securing. <br>
 * <br>
 * This domain model have no corresponding table in a database and has a fixed
 * length of records that should see as the types of what to secure. <br>
 * It's only for a better overview in the security managing tools. <br>
 * <br>
 * Int | Type <br>
 * --------------------------<br>
 * 0 | Page <br>
 * 1 | Menu Category <br>
 * 2 | Menu Item <br>
 * 3 | Method/Event <br>
 * 4 | DomainObject/Property <br>
 * 5 | Tab <br>
 * 6 | Component <br>
 * 
 * @author sge@forsthaus.de
 */
public class SecTyp implements Serializable {

	private static final long serialVersionUID = 5129871978459891412L;

	private int stpId;
	private String stpTypname;

	public SecTyp() {
	}

	public SecTyp(int stpId, String stp_typname) {
		this.stpId = stpId;
		this.stpTypname = stp_typname;

	}

	public void setStpId(int stpId) {
		this.stpId = stpId;
	}

	public int getStpId() {
		return stpId;
	}

	public void setStpTypname(String stpTypname) {
		this.stpTypname = stpTypname;
	}

	public String getStpTypname() {
		return stpTypname;
	}

	public List<SecTyp> getAllTypes() {

		List<SecTyp> result = new ArrayList<SecTyp>();

		result.add(new SecTyp(0, "Page"));
		result.add(new SecTyp(1, "Menu Category"));
		result.add(new SecTyp(2, "Menu Item"));
		result.add(new SecTyp(3, "Method"));
		result.add(new SecTyp(4, "DomainObject/Property"));
		result.add(new SecTyp(5, "Tab"));
		result.add(new SecTyp(6, "Component"));

		return result;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(getStpId()).hashCode();
	}

	public boolean equals(SecTyp secTyp) {
		return getStpId() == secTyp.getStpId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof SecTyp) {
			SecTyp secTyp = (SecTyp) obj;
			return equals(secTyp);
		}

		return false;
	}
}
