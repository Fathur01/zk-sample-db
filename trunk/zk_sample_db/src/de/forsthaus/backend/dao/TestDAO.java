package de.forsthaus.backend.dao;

import java.util.List;

import com.trg.search.SearchResult;

import de.forsthaus.backend.util.HibernateSearchObject;

public interface TestDAO {

	public List<?> getBySearchObject(HibernateSearchObject so, int start, int pageSize);

	public SearchResult<?> getSRBySearchObject(HibernateSearchObject so, int start, int pageSize);

}
