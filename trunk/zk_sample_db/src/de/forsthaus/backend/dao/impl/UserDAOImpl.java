/**
 * 
 */
package de.forsthaus.backend.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.UserDAO;
import de.forsthaus.backend.model.SecUser;

/**
 * @author sge
 * 
 */
public class UserDAOImpl extends BasisfNextidviewImpl<SecUser> implements UserDAO {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.daibutsu.backend.dao.KundeDAO#create(de.daibutsu.backend.model.Filiale
	 * )
	 */
	@Override
	public SecUser create() {
		SecUser user = new SecUser();
		user.setUsrId(getNextId());

		return user;
	}

	@Override
	public SecUser getNewSecUser() {
		return new SecUser();
	}

	@Override
	public void saveOrUpdate(SecUser user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecUser> getAlleUser() {
		return getHibernateTemplate().loadAll(SecUser.class);
	}

	/**
	 * Gibt einen User zurueck
	 * 
	 * @param kun_id
	 *            (int)
	 * @return Filuser
	 */
	public SecUser getUserByID(final long usr_id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrId", usr_id));

		return (SecUser) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	public SecUser getUserByFiluserNr(String usr_nr) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrNr", usr_nr));

		return (SecUser) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	public SecUser getUserByLoginname(final String userName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrLoginname", userName));
		return (SecUser) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	/**
	 * Gibt ein User Object zurueck.
	 * 
	 * @param string
	 *            (String)
	 * @return Kunde (List)
	 */
	public SecUser getUserByNameAndPassword(final String userName, final String userPassword) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrLoginname", userName));
		criteria.add(Restrictions.eq("usrPassword", userPassword));

		return (SecUser) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public void delete(SecUser entity) throws DataAccessException {
		super.delete(entity);
	}

	@Override
	public void save(SecUser entity) throws DataAccessException {
		super.save(entity);
	}

	@Override
	public List<SecUser> getUserLikeLastname(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.like("usrLastname", value, MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<SecUser> getUserLikeLoginname(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.like("usrLoginname", value, MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<SecUser> getUserLikeEmail(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.like("usrEmail", value, MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<SecUser> getUserListByLoginname(String userName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.like("usrLoginname", userName));

		return getHibernateTemplate().findByCriteria(criteria);

	}

}
