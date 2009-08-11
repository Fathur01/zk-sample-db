package de.forsthaus.backend.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.SecGroupDAO;
import de.forsthaus.backend.model.SecGroup;
import de.forsthaus.backend.model.SecGroupright;
import de.forsthaus.backend.model.SecRolegroup;
import de.forsthaus.backend.model.SecUser;

public class SecGroupDAOImpl extends BasisfNextidviewImpl<SecGroup> implements SecGroupDAO {

	@Override
	public SecGroup create() {
		SecGroup secGroup = new SecGroup();
		secGroup.setGrpId(getNextId());

		return secGroup;
	}

	@Override
	public SecGroup getNewSecGroup() {
		return new SecGroup();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecGroup> getAllGroups() {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		criteria.addOrder(Order.asc("grpShortdescription"));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public void saveOrUpdate(SecGroup secGroup) {
		getHibernateTemplate().saveOrUpdate(secGroup);
	}

	@Override
	public void delete(SecGroup entity) throws DataAccessException {
		super.delete(entity);
	}

	@Override
	public SecGroup getSecGroupById(long secGroup_id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		criteria.add(Restrictions.eq("grpId", secGroup_id));

		return (SecGroup) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public SecGroup getGroupByGroupRight(SecGroupright secGroupright) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		// Aliases are working only on properties
		criteria.createAlias("secGrouprights", "gr");
		criteria.add(Restrictions.eq("gr.griId", secGroupright.getGriId()));

		// return (SysMenuCategory)
		// getHibernateTemplate().findByCriteria(criteria);
		return (SecGroup) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));

	}

	@Override
	public SecGroup getGroupByRolegroup(SecRolegroup secRolegroup) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.add(Restrictions.eq("rg.rlgId", secRolegroup.getRlgId()));

		// return (SysMenuCategory)
		// getHibernateTemplate().findByCriteria(criteria);
		return (SecGroup) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecGroup> getGroupsByUser(SecUser user) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.createAlias("secRoles", "rol");
		criteria.add(Restrictions.eq("rg.rol.secUser", user));

		// return (SysMenuCategory)
		// getHibernateTemplate().findByCriteria(criteria);
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<SecGroup> getGroupsLikeGroupName(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);
		criteria.add(Restrictions.ilike("grpShortdescription", value, MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);
	}

}
