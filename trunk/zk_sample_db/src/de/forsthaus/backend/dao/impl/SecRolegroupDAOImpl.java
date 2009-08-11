package de.forsthaus.backend.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.SecGroupDAO;
import de.forsthaus.backend.dao.SecRoleDAO;
import de.forsthaus.backend.dao.SecRolegroupDAO;
import de.forsthaus.backend.model.SecGroup;
import de.forsthaus.backend.model.SecGroupright;
import de.forsthaus.backend.model.SecRole;
import de.forsthaus.backend.model.SecRolegroup;

public class SecRolegroupDAOImpl extends BasisfNextidviewImpl<SecRolegroup> implements SecRolegroupDAO {

	private SecRoleDAO secRoleDAO;
	private SecGroupDAO secGroupDAO;

	public void setSecRoleDAO(SecRoleDAO secRoleDAO) {
		this.secRoleDAO = secRoleDAO;
	}

	public SecRoleDAO getSecRoleDAO() {
		return secRoleDAO;
	}

	public void setSecGroupDAO(SecGroupDAO secGroupDAO) {
		this.secGroupDAO = secGroupDAO;
	}

	public SecGroupDAO getSecGroupDAO() {
		return secGroupDAO;
	}

	@Override
	public SecRolegroup create() {
		SecRolegroup secRolegroup = new SecRolegroup();
		secRolegroup.setRlgId(getNextId());

		return secRolegroup;
	}

	@Override
	public SecRolegroup getNewSecRolegroup() {
		return new SecRolegroup();
	}

	@Override
	public void saveOrUpdate(SecRolegroup roleGroup) {
		getHibernateTemplate().saveOrUpdate(roleGroup);
	}

	@Override
	public void delete(SecRolegroup roleGroup) throws DataAccessException {
		super.delete(roleGroup);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecGroup> getGroupsByRole(SecRole role) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecGroup.class);

		// Aliases are working only on properties
		criteria.createAlias("secRolegroups", "rg");
		criteria.add(Restrictions.eq("rg.secRole", role));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecRolegroup> getAllRolegroups() {
		return getHibernateTemplate().loadAll(SecRolegroup.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecRolegroup> getAllRolegroupsComplete() {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRolegroup.class);

		Collection<SecGroup> listGroup = getSecGroupDAO().getAllGroups();
		Collection<SecRole> listRole = getSecRoleDAO().getAllRoles();

		criteria.add(Expression.in("secGroup", listGroup));
		criteria.add(Expression.in("secRole", listRole));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public SecRolegroup getRolegroupByRoleAndGroup(SecRole role, SecGroup group) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRolegroup.class);
		criteria.add(Restrictions.eq("secRole", role));
		criteria.add(Restrictions.eq("secGroup", group));

		return (SecRolegroup) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));

	}

	@Override
	public boolean isGroupInRole(SecGroup group, SecRole role) {

		boolean result = false;

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRolegroup.class);
		criteria.add(Restrictions.eq("secGroup", group));
		criteria.add(Restrictions.eq("secRole", role));

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

}
