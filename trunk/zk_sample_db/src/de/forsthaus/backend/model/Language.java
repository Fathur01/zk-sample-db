package de.forsthaus.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the languages that have i3label property files. <br>
 * <br>
 * The domain model have no corresponding table in a database and has a fixed
 * length of records that should see as the types of login status. <br>
 * <br>
 * String | Type <br>
 * --------------------------<br>
 * de_DE | German <br>
 * en_EN | English <br>
 * 
 * @author sge@forsthaus.de
 * @changes 03/23/2009/sge Changed field 'lanId' from int to String(5).<br>
 */
public class Language implements Serializable {

	private static final long serialVersionUID = -3863392491172579819L;

	private String lanId;
	private String lanText;

	public Language() {
	}

	public Language(String lanId, String lanText) {
		this.setLanId(lanId);
		this.setLanText(lanText);

	}

	public void setLanId(String lanId) {
		this.lanId = lanId;
	}

	public String getLanId() {
		return lanId;
	}

	public void setLanText(String lanText) {
		this.lanText = lanText;
	}

	public String getLanText() {
		return lanText;
	}

	public List<Language> getAllLanguages() {

		List<Language> result = new ArrayList<Language>();

		result.add(new Language(null, null));
		result.add(new Language("de_DE", "german"));
		result.add(new Language("en_EN", "english"));

		return result;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(getLanId()).hashCode();
	}

	public boolean equals(Language language) {
		return getLanId() == language.getLanId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Language) {
			Language language = (Language) obj;
			return equals(language);
		}

		return false;
	}

}
