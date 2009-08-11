package de.forsthaus.backend.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.SecGroupDAO;
import de.forsthaus.backend.dao.SecGrouprightDAO;
import de.forsthaus.backend.dao.SecRightDAO;
import de.forsthaus.backend.model.SecGroup;
import de.forsthaus.backend.model.SecGroupright;
import de.forsthaus.backend.model.SecRight;

public class SecGrouprightDAOImpl extends BasisfNextidviewImpl<SecGroupright> implements SecGrouprightDAO {

	private SecGroupDAO secGroupDAO;
	private SecRightDAO secRightDAO;

	public void setSecGroupDAO(SecGroupDAO secGroupDAO) {
		this.secGroupDAO = secGroupDAO;
	}

	public SecGroupDAO getSecGroupDAO() {
		return secGroupDAO;
	}

	public void setSecRightDAO(SecRightDAO secRightDAO) {
		this.secRightDAO = secRightDAO;
	}

	public SecRightDAO getSecRightDAO() {
		return secRightDAO;
	}

	@Override
	public SecGroupright create() {
		SecGroupright secGroupright = new SecGroupright();
		secGroupright.setGriId(getNextId());

		return secGroupright;
	}

	@Override
	public SecGroupright getNewSecGroupright() {
		return new SecGroupright();
	}

	@Override
	public void saveOrUpdate(SecGroupright secGroupright) {
		getHibernateTemplate().saveOrUpdate(secGroupright);
	}

	@Override
	public void delete(SecGroupright secGroupright) throws DataAccessException {
		super.delete(secGroupright);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecRight> getRightsByGroup(SecGroup group) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		// Aliases are working only on properties they build the JOINS
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.secGroup", group));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public SecRight getRightById(long right_id) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		criteria.add(Restrictions.eq("rigId", right_id));

		return (SecRight) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecGroupright> getAllGroupRights() {
		return getHibernateTemplate().loadAll(SecGroupright.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecGroupright> getAllGroupRightsComplete() {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroupright.class);

		Collection<SecGroup> listGroup = getSecGroupDAO().getAllGroups();
		Collection<SecRight> listRight = getSecRightDAO().getAllRights(-1);

		criteria.add(Expression.in("secGroup", listGroup));
		criteria.add(Expression.in("secRight", listRight));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public boolean isRightInGroup(SecRight right, SecGroup group) {

		boolean result = false;

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroupright.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRight", right));

		List<SecGroupright> list = getHibernateTemplate().findByCriteria(criteria);

		if (list == null) {
			return result;
		}

		if (list.size() > 0) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public SecGroupright getGroupRightByGroupAndRight(SecGroup group, SecRight right) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroupright.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRight", right));

		return (SecGroupright) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public List<SecRight> getGroupRightsByGroup(SecGroup group) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		// criteria.createAlias("gr.secGroup", "g");

		criteria.add(Restrictions.eq("gr.secGroup", group));

		return getHibernateTemplate().findByCriteria(criteria);

	}
}