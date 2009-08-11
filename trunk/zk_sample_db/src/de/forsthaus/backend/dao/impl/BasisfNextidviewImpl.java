/**
 * 
 */
package de.forsthaus.backend.dao.impl;

import de.forsthaus.backend.dao.NextidviewDAO;

/**
 * @author bj
 * 
 */
abstract public class BasisfNextidviewImpl<T> extends BasisDAO<T> {
	private NextidviewDAO nextidviewDAO;

	public NextidviewDAO getNextidviewDAO() {
		return nextidviewDAO;
	}

	public void setNextidviewDAO(NextidviewDAO nextidviewDAO) {
		this.nextidviewDAO = nextidviewDAO;
	}

	protected long getNextId() {
		return getNextidviewDAO().getNextId();
	}
}
