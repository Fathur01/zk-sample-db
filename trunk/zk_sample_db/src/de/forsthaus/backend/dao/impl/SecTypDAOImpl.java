/**
 * 
 */
package de.forsthaus.backend.dao.impl;

import java.util.List;

import de.forsthaus.backend.dao.SecTypDAO;
import de.forsthaus.backend.model.SecTyp;

/**
 * @author sge@forsthaus.de
 * 
 */
public class SecTypDAOImpl implements SecTypDAO {

	@Override
	public List<SecTyp> getAllTypes() {
		return new SecTyp().getAllTypes();
	}

	@Override
	public SecTyp getTypById(int typ_id) {

		SecTyp result = null;

		List<SecTyp> list = getAllTypes();

		try {
			result = list.get(typ_id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

}
