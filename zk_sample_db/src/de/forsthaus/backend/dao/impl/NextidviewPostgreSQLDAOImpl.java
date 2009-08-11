package de.forsthaus.backend.dao.impl;

import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.NextidviewDAO;
import de.forsthaus.backend.model.Nextidview;

/**
 * @author bj
 * 
 */
public class NextidviewPostgreSQLDAOImpl extends BasisDAO<Nextidview> implements NextidviewDAO {

	/**
	 * Gives back the next primary key id value. <br>
	 * <br>
	 * Here: for PostgreSQL which have a sequence that holds the primary Key
	 * value <br>
	 * and a view that calls the the sequence 'nextval()' <br>
	 * 
	 * @return NextID (Integer)
	 */
	@SuppressWarnings("unchecked")
	public long getNextId() {

		return ((Nextidview) DataAccessUtils.uniqueResult(getHibernateTemplate().find("from Nextidview"))).getNextval();
	}

}
