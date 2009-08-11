/**
 * 
 */
package de.forsthaus.backend.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import de.forsthaus.backend.dao.LanguageDAO;
import de.forsthaus.backend.model.Language;

/**
 * @author sge@forsthaus.de
 * 
 */
public class LanguageDAOImpl implements LanguageDAO {

	@Override
	public List<Language> getAllLanguages() {
		return new Language().getAllLanguages();
	}

	@Override
	public Language getLanguageById(String lan_id) {

		Language result = null;

		// check if empty
		if (StringUtils.isEmpty(lan_id)) {
			return result;
		}

		List<Language> list = getAllLanguages();

		for (Language language : list) {
			if (StringUtils.equals(language.getLanId(), lan_id)) {
				return language;
			}
		}

		return result;
	}
}
