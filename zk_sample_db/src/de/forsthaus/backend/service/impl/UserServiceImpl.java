/**
 * 
 */
package de.forsthaus.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.list.SetUniqueList;
import org.apache.log4j.Logger;

import de.forsthaus.backend.dao.LanguageDAO;
import de.forsthaus.backend.dao.SecGroupDAO;
import de.forsthaus.backend.dao.SecGrouprightDAO;
import de.forsthaus.backend.dao.SecRoleDAO;
import de.forsthaus.backend.dao.SecRolegroupDAO;
import de.forsthaus.backend.dao.SecUserroleDAO;
import de.forsthaus.backend.dao.UserDAO;
import de.forsthaus.backend.model.Language;
import de.forsthaus.backend.model.SecGroup;
import de.forsthaus.backend.model.SecRight;
import de.forsthaus.backend.model.SecRole;
import de.forsthaus.backend.model.SecUser;
import de.forsthaus.backend.service.UserService;

/**
 * @author sge/Forsthaus Datentechnik
 * 
 */
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	private UserDAO userDAO;
	private SecUserroleDAO secUserroleDAO;
	private SecRoleDAO secRoleDAO;
	private SecRolegroupDAO secRolegroupDAO;
	private SecGrouprightDAO secGrouprightDAO;
	private SecGroupDAO secGroupDAO;
	private LanguageDAO languageDAO;

	public LanguageDAO getLanguageDAO() {
		return languageDAO;
	}

	public void setLanguageDAO(LanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}

	public SecGroupDAO getSecGroupDAO() {
		return secGroupDAO;
	}

	public void setSecGroupDAO(SecGroupDAO secGroupDAO) {
		this.secGroupDAO = secGroupDAO;
	}

	public SecGrouprightDAO getSecGrouprightDAO() {
		return secGrouprightDAO;
	}

	public void setSecGrouprightDAO(SecGrouprightDAO secGrouprightDAO) {
		this.secGrouprightDAO = secGrouprightDAO;
	}

	public SecRolegroupDAO getSecRolegroupDAO() {
		return secRolegroupDAO;
	}

	public void setSecRolegroupDAO(SecRolegroupDAO secRolegroupDAO) {
		this.secRolegroupDAO = secRolegroupDAO;
	}

	public SecUserroleDAO getSecUserroleDAO() {
		return secUserroleDAO;
	}

	public void setSecUserroleDAO(SecUserroleDAO secUserroleDAO) {
		this.secUserroleDAO = secUserroleDAO;
	}

	public SecRoleDAO getSecRoleDAO() {
		return secRoleDAO;
	}

	public void setSecRoleDAO(SecRoleDAO secRoleDAO) {
		this.secRoleDAO = secRoleDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public SecUser getNewUser() {
		return getUserDAO().getNewSecUser();
	}

	@Override
	public List<SecUser> getAlleUser() {
		return getUserDAO().getAlleUser();
	}

	@Override
	public void saveOrUpdate(SecUser user) {
		if (user.isNew()) {

			SecUser newUser = getUserDAO().create();
			user.setUsrId(newUser.getUsrId());
		}
		getUserDAO().saveOrUpdate(user);
	}

	@Override
	public void delete(SecUser user) {
		getUserDAO().delete(user);
	}

	@Override
	public SecUser getUserByLoginname(final String userName) {
		return getUserDAO().getUserByLoginname(userName);
	}

	@Override
	public List<SecRole> getRolesByUser(SecUser user) {
		return getSecRoleDAO().getRolesByUser(user);
	}

	@Override
	public List<SecRole> getAllRoles() {
		return getSecRoleDAO().getAllRoles();
	}

	@Override
	public List<SecGroup> getGroupsByUser(SecUser user) {

		List<SecGroup> listGroup = new ArrayList<SecGroup>();

		listGroup = getSecGroupDAO().getGroupsByUser(user);

		return listGroup;
	}

	@Override
	public List<SecRight> getRightsByUser(SecUser user) {

		List rightList = new ArrayList<SecRight>();

		// 1. erst die zum User zugeteilten Rollen ermitteln
		// 1. First get the roles that are attached to a user
		List<SecRole> listRoles = new ArrayList<SecRole>();
		listRoles = getRolesByUser(user);

		if (logger.isDebugEnabled()) {
			if (listRoles != null) {
				for (SecRole secRole : listRoles) {
					logger.info(secRole.getRolShortdescription());
				}
			}
		}

		// 2. die zu den Rollen die zugehörigen Gruppen ermitteln
		// 2. get the groups that belongs to the roles
		List<SecGroup> listGroup = new ArrayList<SecGroup>();

		if (listRoles != null) {
			for (SecRole role : listRoles) {

				List<SecGroup> tmpListGroup = new ArrayList<SecGroup>();
				tmpListGroup = getSecRolegroupDAO().getGroupsByRole(role);

				if (tmpListGroup != null) {
					for (SecGroup secGroup : tmpListGroup) {
						listGroup.add(secGroup);
					}
				}

			}
		}

		if (logger.isDebugEnabled()) {
			if (listGroup != null) {
				for (SecGroup secGroup : listGroup) {
					logger.info(secGroup.getGrpShortdescription());
				}
			}
		}

		// 3. zu den Gruppen die zugeordneten Rechte ermitteln
		// 3. get the rights that belongs to the groups
		List<SecRight> listRight = new ArrayList<SecRight>();

		if (listGroup != null) {
			for (SecGroup group : listGroup) {

				List<SecRight> tmpListRight = new ArrayList<SecRight>();
				tmpListRight = getSecGrouprightDAO().getRightsByGroup(group);

				if (tmpListRight != null) {
					for (SecRight secRight : tmpListRight) {
						listRight.add(secRight);
					}
				}
			}
		}

		if (logger.isDebugEnabled()) {
			if (listRight != null) {
				for (SecRight secRight : listRight) {
					logger.info(secRight.getRigName());
				}
			}
		}

		// 4. Doppelte Rechte unterdrücken
		// 4. filter double rights out
		if (listRight != null) {

			List decorateList = SetUniqueList.decorate(rightList);
			for (int i = 0; i < listRight.size(); i++) {
				decorateList.add(listRight.get(i));
			}
		}

		if (logger.isDebugEnabled()) {
			logger.info("--> Decorated List");
			if (rightList != null) {
				for (SecRight secRight : (List<SecRight>) rightList) {
					logger.info(secRight.getRigName());
				}
			}
		}

		return rightList;
	}

	@Override
	public List<SecUser> getUserLikeLastname(String value) {
		return getUserDAO().getUserLikeLastname(value);
	}

	@Override
	public List<SecUser> getUserLikeLoginname(String value) {
		return getUserDAO().getUserLikeLoginname(value);
	}

	@Override
	public List<SecUser> getUserLikeEmail(String value) {
		return getUserDAO().getUserLikeEmail(value);
	}

	@Override
	public List<SecUser> getUserListByLoginname(String userName) {
		return getUserDAO().getUserListByLoginname(userName);
	}

	@Override
	public List<Language> getAllLanguages() {
		return getLanguageDAO().getAllLanguages();
	}

	@Override
	public Language getLanguageById(String lan_id) {
		return getLanguageDAO().getLanguageById(lan_id);
	}
}
