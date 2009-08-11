package de.forsthaus.backend.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.SecRoleDAO;
import de.forsthaus.backend.dao.SecUserroleDAO;
import de.forsthaus.backend.dao.UserDAO;
import de.forsthaus.backend.model.SecRole;
import de.forsthaus.backend.model.SecUser;
import de.forsthaus.backend.model.SecUserrole;

public class SecUserroleDAOImpl extends BasisfNextidviewImpl<SecUserrole> implements SecUserroleDAO {

	private UserDAO userDAO;
	private SecRoleDAO secRoleDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public SecRoleDAO getSecRoleDAO() {
		return secRoleDAO;
	}

	public void setSecRoleDAO(SecRoleDAO secRoleDAO) {
		this.secRoleDAO = secRoleDAO;
	}

	@Override
	public SecUserrole create() {
		SecUserrole secUserrole = new SecUserrole();
		secUserrole.setUrrId(getNextId());

		return secUserrole;
	}

	@Override
	public SecUserrole getNewSecUserrole() {
		return new SecUserrole();
	}

	@Override
	public void saveOrUpdate(SecUserrole secUserrole) {
		getHibernateTemplate().saveOrUpdate(secUserrole);
	}

	@Override
	public void delete(SecUserrole secUserrole) throws DataAccessException {
		super.delete(secUserrole);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecUserrole> getAllUserRoles() {
		return getHibernateTemplate().loadAll(SecUserrole.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecUserrole> getAllUserRolesComplete() {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecUserrole.class);

		Collection<SecUser> listUser = getUserDAO().getAlleUser();
		Collection<SecRole> listRole = getSecRoleDAO().getAllRoles();

		criteria.add(Expression.in("secUser", listUser));
		criteria.add(Expression.in("secRole", listRole));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public SecUserrole getUserroleByUserAndRole(SecUser user, SecRole role) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecUserrole.class);
		criteria.add(Restrictions.eq("secRole", role));
		criteria.add(Restrictions.eq("secUser", user));

		return (SecUserrole) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public boolean isUserInRole(SecUser user, SecRole role) {
		boolean result = false;

		DetachedCriteria criteria = DetachedCriteria.forClass(SecUserrole.class);
		criteria.add(Restrictions.eq("secUser", user));
		criteria.add(Restrictions.eq("secRole", role));

		List<SecUserrole> list = getHibernateTemplate().findByCriteria(criteria);

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
