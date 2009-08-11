package de.forsthaus.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the status of logins. <br>
 * <br>
 * The domain model have no corresponding table in a database and has a fixed
 * length of records that should see as the types of login status. <br>
 * <br>
 * Int | Type <br>
 * --------------------------<br>
 * 0 | login failed <br>
 * 1 | login <br>
 * 2 | logout <br>
 * 
 * @author sge@forsthaus.de
 */
public class LoginStatus implements Serializable {

	private static final long serialVersionUID = -3863392491172579819L;

	private int lgsId;
	private String lgsStatus;

	public LoginStatus() {
	}

	public LoginStatus(int lgsId, String lgsStatus) {
		this.lgsId = lgsId;
		this.lgsStatus = lgsStatus;

	}

	public void setLgsId(int lgsId) {
		this.lgsId = lgsId;
	}

	public int getLgsId() {
		return lgsId;
	}

	public void setLgsStatus(String lgsStatus) {
		this.lgsStatus = lgsStatus;
	}

	public String getStpTypname() {
		return lgsStatus;
	}

	public List<LoginStatus> getAllTypes() {

		List<LoginStatus> result = new ArrayList<LoginStatus>();

		result.add(new LoginStatus(0, "login failed"));
		result.add(new LoginStatus(1, "login"));
		result.add(new LoginStatus(2, "login"));

		return result;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(getLgsId()).hashCode();
	}

	public boolean equals(LoginStatus loginStatus) {
		return getLgsId() == loginStatus.getLgsId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof LoginStatus) {
			LoginStatus loginStatus = (LoginStatus) obj;
			return equals(loginStatus);
		}

		return false;
	}
}
