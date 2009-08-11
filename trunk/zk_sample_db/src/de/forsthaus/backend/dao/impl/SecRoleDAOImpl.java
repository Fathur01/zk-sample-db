package de.forsthaus.backend.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.SecRoleDAO;
import de.forsthaus.backend.model.SecRole;
import de.forsthaus.backend.model.SecUser;

public class SecRoleDAOImpl extends BasisfNextidviewImpl<SecRole> implements SecRoleDAO {

	@Override
	public SecRole create() {
		SecRole secRole = new SecRole();
		secRole.setRolId(getNextId());

		return secRole;
	}

	@Override
	public SecRole getNewSecRole() {
		return new SecRole();
	}

	@Override
	public void saveOrUpdate(SecRole secRole) {
		getHibernateTemplate().saveOrUpdate(secRole);
	}

	@Override
	public void delete(SecRole secRole) throws DataAccessException {
		super.delete(secRole);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecRole> getAllRoles() {
		return getHibernateTemplate().loadAll(SecRole.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecRole> getRolesByUser(SecUser user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRole.class);

		// Aliases are working only on properties
		criteria.createAlias("secUserroles", "rol");
		criteria.add(Restrictions.eq("rol.secUser", user));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public SecRole getRoleById(long role_Id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecRole.class);
		criteria.add(Restrictions.eq("rolId", role_Id));

		return (SecRole) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));

	}

	@Override
	public List<SecRole> getRolesLikeRoleName(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecRole.class);
		criteria.add(Restrictions.ilike("rolShortdescription", value, MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);
	}

}
