package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.Language;

public interface LanguageDAO {

	public List<Language> getAllLanguages();

	public Language getLanguageById(String lan_id);
}
