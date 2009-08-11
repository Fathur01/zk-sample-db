package de.forsthaus.backend.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import de.forsthaus.backend.dao.UserDAO;
import de.forsthaus.backend.model.SecUser;
import de.forsthaus.backend.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private static Logger logger = Logger.getLogger(LoginServiceImpl.class);

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public SecUser getLoginUser(String usrLoginName, String usrPassword) {

		if (StringUtils.isBlank(usrLoginName)) {
			return null;
		}
		if (StringUtils.isBlank(usrPassword)) {
			return null;
		}

		return getUserDAO().getUserByNameAndPassword(usrLoginName, usrPassword);
	}

	/*
	 * @Override public List<SysMenuCategory> getMenuCategoriesByUser(SecUser
	 * user) {
	 * 
	 * List<SysMenuItem> listMenuItem = new ArrayList<SysMenuItem>(); // init
	 * List<SysMenuCategory> listMenuCategory = new
	 * ArrayList<SysMenuCategory>(); // init List<SysUsergroup> listUsergroup =
	 * new ArrayList<SysUsergroup>(); // init
	 * 
	 * // get all usergroups for a user listUsergroup =
	 * getSysUsergroupDAO().getUsergroupsByUser(user);
	 * 
	 * // get all SysMenuItems for a usergroup if (listUsergroup != null) { for
	 * (SysUsergroup sysUsergroup : listUsergroup) {
	 * 
	 * if (logger.isInfoEnabled()) { logger.info("--> " +
	 * sysUsergroup.getRolShortdescription());
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * listMenuItem.addAll(getSysMenuItemDAO().getMenuItemsByUsergroup(sysUsergroup
	 * )); } } }
	 * 
	 * // get all MenuCategories that are in the list of menuItems // The
	 * SetUniqueList checks that no items are double. if
	 * (!listMenuItem.isEmpty()) {
	 * 
	 * List decorateList = SetUniqueList.decorate(listMenuCategory); for (int i
	 * = 0; i < listMenuItem.size(); i++) {
	 * //listMenuCategory.add(listMenuItem.get(i).getSysMenuCategory()) // ;
	 * decorateList
	 * .add(getSysMenuCategoryDAO().getMenuCategoryByMenuItem(listMenuItem
	 * .get(i))); } } return listMenuCategory; }
	 */

}
