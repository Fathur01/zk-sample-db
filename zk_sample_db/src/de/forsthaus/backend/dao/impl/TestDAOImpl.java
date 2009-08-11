package de.forsthaus.backend.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.trg.search.SearchResult;
import com.trg.search.hibernate.HibernateSearchProcessor;

import de.forsthaus.backend.dao.TestDAO;
import de.forsthaus.backend.util.HibernateSearchObject;

/**
 * @author sge
 * 
 * 
 * 
 */
public class TestDAOImpl extends BasisDAO implements TestDAO {

	@Override
	public List<?> getBySearchObject(HibernateSearchObject so, int start, int pageSize) {

		SessionFactory sf = getHibernateTemplate().getSessionFactory();
		Session ss = getHibernateTemplate().getSessionFactory().getCurrentSession();

		HibernateSearchProcessor hsp = HibernateSearchProcessor.getInstanceForSessionFactory(sf);

		so.setFirstResult(start);
		so.setMaxResults(pageSize);

		List<?> list = hsp.search(ss, so);

		return list;
	}

	@Override
	public SearchResult<?> getSRBySearchObject(HibernateSearchObject so, int start, int pageSize) {

		SessionFactory sf = getHibernateTemplate().getSessionFactory();
		Session ss = getHibernateTemplate().getSessionFactory().getCurrentSession();

		HibernateSearchProcessor hsp = HibernateSearchProcessor.getInstanceForSessionFactory(sf);

		so.setFirstResult(start);
		so.setMaxResults(pageSize);

		SearchResult<?> searchresult = hsp.searchAndCount(ss, so);

		return searchresult;
	}

}
