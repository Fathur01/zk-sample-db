package de.forsthaus.backend.util;

import java.io.Serializable;

import com.trg.search.Search;

/**
 * SearchObject depending on the Search Object from the Hibernate-Generic-DAO
 * framework. <br>
 * 
 * @see http://code.google.com/p/hibernate-generic-dao/ <br>
 *      Many thanks to David Wolvert.
 * 
 * @author sge
 * 
 * @param <E>
 */
public class HibernateSearchObject<T> extends Search implements Serializable {

	private static final long serialVersionUID = 1L;

	public HibernateSearchObject(Class<T> entityClass) {
		super(entityClass);
	}
}
