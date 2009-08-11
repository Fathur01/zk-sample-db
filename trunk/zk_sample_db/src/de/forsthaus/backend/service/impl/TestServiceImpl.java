/**
 * 
 */
package de.forsthaus.backend.service.impl;

import java.util.List;

import com.trg.search.SearchResult;

import de.forsthaus.backend.dao.TestDAO;
import de.forsthaus.backend.service.TestService;
import de.forsthaus.backend.util.HibernateSearchObject;

/**
 * @author bj
 * 
 */
public class TestServiceImpl implements TestService {

	private TestDAO testDAO;

	public void setTestDAO(TestDAO testDAO) {
		this.testDAO = testDAO;
	}

	public TestDAO getTestDAO() {
		return testDAO;
	}

	@Override
	public List<?> getBySearchObject(HibernateSearchObject so, int start, int pageSize) {
		return getTestDAO().getBySearchObject(so, start, pageSize);
	}

	@Override
	public SearchResult<?> getSRBySearchObject(HibernateSearchObject so, int start, int pageSize) {
		return getTestDAO().getSRBySearchObject(so, start, pageSize);
	}

}
