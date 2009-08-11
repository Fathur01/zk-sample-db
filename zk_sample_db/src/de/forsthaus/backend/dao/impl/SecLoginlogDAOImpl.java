package de.forsthaus.backend.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.SecLoginlogDAO;
import de.forsthaus.backend.model.LoginStatus;
import de.forsthaus.backend.model.SecLoginlog;

public class SecLoginlogDAOImpl extends BasisfNextidviewImpl<SecLoginlog> implements SecLoginlogDAO {

	@Override
	public SecLoginlog create() {
		SecLoginlog secLoginlog = new SecLoginlog();
		secLoginlog.setLglId(getNextId());

		return secLoginlog;
	}

	@Override
	public SecLoginlog getNewSecLoginlog() {
		return new SecLoginlog();
	}

	@Override
	public void saveOrUpdate(SecLoginlog secLoginlog) {
		getHibernateTemplate().saveOrUpdate(secLoginlog);
	}

	@Override
	public void delete(SecLoginlog secLoginlog) throws DataAccessException {
		super.delete(secLoginlog);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecLoginlog> getAllLogs() {
		// return getHibernateTemplate().loadAll(SecLoginlog.class);

		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		criteria.addOrder(Order.desc("lglLogtime"));

		return getHibernateTemplate().findByCriteria(criteria);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecLoginlog> getLogsByLoginname(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		criteria.add(Restrictions.eq("lglLoginname", value));
		criteria.addOrder(Order.desc("lglLogtime"));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public SecLoginlog getLoginlogById(long log_Id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		criteria.add(Restrictions.eq("uslId", log_Id));
		criteria.addOrder(Order.desc("lglLogtime"));

		return (SecLoginlog) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public List<SecLoginlog> getAllLogsForFailed() {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		criteria.add(Restrictions.eq("lglStatusid", 0));
		criteria.addOrder(Order.desc("lglLogtime"));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<SecLoginlog> getAllLogsForSuccess() {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		criteria.add(Restrictions.eq("lglStatusid", 1));
		criteria.addOrder(Order.desc("lglLogtime"));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<SecLoginlog> getLogsByPeriod(Date dateFrom, Date dateTo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecLoginlog.class);
		/**
		 * we set the dateFrom time manually to hh/mm/ss = 00:00:01 and the
		 * dateTo time manually to date + hh/mm/SS = 23:59:59
		 */
		Calendar calFrom = Calendar.getInstance();
		calFrom.setTime(dateFrom);
		calFrom.set(Calendar.AM_PM, 0);
		calFrom.set(Calendar.HOUR, 0);
		calFrom.set(Calendar.MINUTE, 0);
		calFrom.set(Calendar.SECOND, 1);
		dateFrom = calFrom.getTime();

		Calendar calTo = Calendar.getInstance();
		calTo.setTime(dateTo);
		calTo.set(Calendar.AM_PM, 1);
		calTo.set(Calendar.HOUR, 11);
		calTo.set(Calendar.MINUTE, 59);
		calTo.set(Calendar.SECOND, 59);
		dateTo = calTo.getTime();

		criteria.add(Restrictions.between("lglLogtime", dateFrom, dateTo));
		criteria.addOrder(Order.desc("lglLogtime"));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<LoginStatus> getAllTypes() {
		return new LoginStatus().getAllTypes();
	}

	@Override
	public LoginStatus getTypById(int typ_id) {

		LoginStatus result = null;

		List<LoginStatus> list = getAllTypes();

		try {
			result = list.get(typ_id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
	}

}
