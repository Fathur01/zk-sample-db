package de.forsthaus.backend.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.SecRightDAO;
import de.forsthaus.backend.model.SecGroupright;
import de.forsthaus.backend.model.SecRight;
import de.forsthaus.backend.model.SecUser;

public class SecRightDAOImpl extends BasisfNextidviewImpl<SecRight> implements SecRightDAO {

	@Override
	public SecRight create() {
		SecRight secRight = new SecRight();
		secRight.setRigId(getNextId());

		return secRight;
	}

	@Override
	public SecRight getNewSecRight() {
		return new SecRight();
	}

	/**
	 * Int | Type <br>
	 * --------------------------<br>
	 * -1 | All (no filter)<br>
	 * 0 | Page <br>
	 * 1 | Menu Category <br>
	 * 2 | Menu Item <br>
	 * 3 | Method <br>
	 * 4 | DomainObject/Property <br>
	 * 5 | Tab <br>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SecRight> getAllRights(int type) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		criteria.addOrder(Order.asc("rigName"));

		if (type != -1) {
			criteria.add(Restrictions.eq("rigType", type));
			// criteria.add(Restrictions.or(Restrictions.eq("rigType", 2),
			// Restrictions.eq("rigType", 1)));
		}

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecRight> getAllRights(List<Integer> list) {

//		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
//		criteria.addOrder(Order.asc("rigName"));

		List<SecRight> result = null; // init

		// check if null
		if (list == null) {
			result = null;
		}

		// check if value is '-1'. it means 'all', no filtering
		for (Integer integer : list) {
			if (integer.equals(new Integer(-1))) {
				return getAllRights(integer.intValue());
			}
		}

		// check if only 1 type
		if (list.size() == 1) {
			int i = list.get(0);
			return getAllRights(i);
		}

		// if more than one type than construct the hql query
		String hqlFrom = " from SecRight as secRight where ";
		// get the first value
		String hqlWhere = " secRight.rigType = " + list.get(0);

		for (int i = 1; i < list.size(); i++) {
			hqlWhere = hqlWhere + " or secRight.rigType = " + list.get(i);
		}

		String hqlQuery = hqlFrom + hqlWhere;

		result = (List<SecRight>) getHibernateTemplate().find(hqlQuery);

		return result;

	}

	@Override
	public void saveOrUpdate(SecRight right) {
		getHibernateTemplate().saveOrUpdate(right);
	}

	@Override
	public void delete(SecRight right) throws DataAccessException {
		super.delete(right);
	}

	@Override
	public SecRight getRightById(long right_id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		criteria.add(Restrictions.eq("rigId", right_id));

		return (SecRight) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecRight> getRightsByGroupright(SecGroupright secGroupright) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		// Aliases only for properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.griId", secGroupright.getGriId()));

		return getHibernateTemplate().findByCriteria(criteria);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecRight> getRightsByUser(SecUser user) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		// Aliases are working only on properties
		criteria.createAlias("secGrouprights", "groupright");
		criteria.createAlias("secGroup", "group");
		criteria.createAlias("secRolegroups", "rg");
		criteria.createAlias("secRoles", "rol");
		criteria.add(Restrictions.eq("groupright.group.rg.rol.secUser", user));

		// return (SysMenuCategory)
		// getHibernateTemplate().findByCriteria(criteria);
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<SecRight> getRightsLikeRightName(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		criteria.add(Restrictions.ilike("rigName", value, MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<SecRight> getRightsLikeRightNameAndType(String value, int type) {

		// check if the empty right is selected. This right is only for visual
		// behavior.
		if (type == -1) {
			return getRightsLikeRightName(value);
		}

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		criteria.add(Restrictions.and(Restrictions.ilike("rigName", value, MatchMode.ANYWHERE), Restrictions.eq("rigType", type)));

		return getHibernateTemplate().findByCriteria(criteria);

	}

	@Override
	public List<SecRight> getRightsLikeRightNameAndTypes(String value, List<Integer> list) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRight.class);
		criteria.addOrder(Order.asc("rigName"));

		List<SecRight> result = null; // init

		// check if null
		if (list == null) {
			result = null;
		}

		String hqlFrom = "";
		String hqlWhere = "";
		String hqlAdd = "";

		// check if value is '-1'. it means 'all', no filtering
		// only if value is empty
		for (Integer integer : list) {
			if (integer.equals(new Integer(-1))) {
				if (value.isEmpty()) {
					return getAllRights(integer.intValue());
				} else if (!value.isEmpty()) {

					hqlFrom = " from SecRight as secRight where ";
					hqlWhere = " secRight.rigName like '%" + value + "%'";
					String hqlQuery = hqlFrom + hqlWhere;

					System.out.println(hqlQuery);

					return (List<SecRight>) getHibernateTemplate().find(hqlQuery);
				}
			}
		}

		// check if only 1 type and value is empty
		if (list.size() == 1) {
			int i = list.get(0);
			if (value.isEmpty()) {
				return getAllRights(i);
			}
		}

		// if more than one type than construct the hql query
		hqlFrom = " from SecRight as secRight where ";
		// get the first value
		hqlWhere = " secRight.rigType = " + list.get(0);

		for (int i = 1; i < list.size(); i++) {
			hqlWhere = hqlWhere + " or secRight.rigType = " + list.get(i);
		}

		String hqlQuery = hqlFrom + hqlWhere;

		if (!value.isEmpty()) {
			// add the right name
			hqlAdd = " and secRight.rigName like '%" + value + "%'";
			hqlQuery = hqlQuery + hqlAdd;
		}

		System.out.println(hqlQuery);

		result = (List<SecRight>) getHibernateTemplate().find(hqlQuery);

		return result;
	}
}
