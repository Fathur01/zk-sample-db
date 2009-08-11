package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.SecTyp;

public interface SecTypDAO {

	public List<SecTyp> getAllTypes();

	public SecTyp getTypById(int typ_id);
}
