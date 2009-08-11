/**
 * 
 */
package de.forsthaus.backend.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import de.forsthaus.backend.dao.SecGroupDAO;
import de.forsthaus.backend.dao.SecGrouprightDAO;
import de.forsthaus.backend.dao.SecRightDAO;
import de.forsthaus.backend.dao.SecRoleDAO;
import de.forsthaus.backend.dao.SecRolegroupDAO;
import de.forsthaus.backend.dao.SecTypDAO;
import de.forsthaus.backend.dao.SecUserroleDAO;
import de.forsthaus.backend.dao.UserDAO;
import de.forsthaus.backend.model.SecGroup;
import de.forsthaus.backend.model.SecGroupright;
import de.forsthaus.backend.model.SecRight;
import de.forsthaus.backend.model.SecRole;
import de.forsthaus.backend.model.SecRolegroup;
import de.forsthaus.backend.model.SecTyp;
import de.forsthaus.backend.model.SecUser;
import de.forsthaus.backend.model.SecUserrole;
import de.forsthaus.backend.service.SecurityService;

/**
 * @author bj
 * 
 */
public class SecurityServiceImpl implements SecurityService {

	private static Logger logger = Logger.getLogger(SecurityServiceImpl.class);

	private UserDAO userDAO;
	private SecUserroleDAO secUserroleDAO;
	private SecRoleDAO secRoleDAO;
	private SecRolegroupDAO secRolegroupDAO;
	private SecGrouprightDAO secGrouprightDAO;
	private SecGroupDAO secGroupDAO;
	private SecRightDAO secRightDAO;
	private SecTypDAO secTypDAO;

	public SecTypDAO getSecTypDAO() {
		return secTypDAO;
	}

	public void setSecTypDAO(SecTypDAO secTypDAO) {
		this.secTypDAO = secTypDAO;
	}

	public SecRightDAO getSecRightDAO() {
		return secRightDAO;
	}

	public void setSecRightDAO(SecRightDAO secRightDAO) {
		this.secRightDAO = secRightDAO;
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
	public List<SecRole> getAllRoles() {
		return getSecRoleDAO().getAllRoles();
	}

	@Override
	public void saveOrUpdate(SecRole role) {
		if (role.isNew()) {

			SecRole newRole = getSecRoleDAO().create();
			role.setRolId(newRole.getRolId());
		}
		getSecRoleDAO().saveOrUpdate(role);
	}

	@Override
	public void delete(SecRole role) {
		getSecRoleDAO().delete(role);
	}

	@Override
	public List<SecGroup> getAllGroups() {
		return getSecGroupDAO().getAllGroups();
	}

	@Override
	public List<SecRight> getAllRights(int type) {
		return getSecRightDAO().getAllRights(type);
	}

	@Override
	public SecGroup getNewSecGroup() {
		return getSecGroupDAO().getNewSecGroup();
	}

	@Override
	public SecRight getNewSecRight() {
		return getSecRightDAO().getNewSecRight();
	}

	@Override
	public SecRole getNewSecRole() {
		return getSecRoleDAO().getNewSecRole();
	}

	@Override
	public List<SecGroupright> getAllGroupRights() {
		return getSecGrouprightDAO().getAllGroupRights();
	}

	@Override
	public List<SecGroupright> getAllGroupRightsComplete() {
		return getSecGrouprightDAO().getAllGroupRightsComplete();
	}

	@Override
	public SecGroupright getNewSecGroupright() {
		return getSecGrouprightDAO().getNewSecGroupright();
	}

	@Override
	public List<SecUserrole> getAllUserRoles() {
		return getSecUserroleDAO().getAllUserRoles();
	}

	@Override
	public List<SecUserrole> getAllUserRolesComplete() {
		return getSecUserroleDAO().getAllUserRolesComplete();
	}

	@Override
	public SecUserrole getNewSecUserrole() {
		return getSecUserroleDAO().getNewSecUserrole();
	}

	@Override
	public SecRolegroup getNewSecRolegroup() {
		return getSecRolegroupDAO().getNewSecRolegroup();
	}

	@Override
	public List<SecRolegroup> getAllRolegroups() {
		return getSecRolegroupDAO().getAllRolegroups();
	}

	@Override
	public List<SecRolegroup> getAllRolegroupsComplete() {
		return getSecRolegroupDAO().getAllRolegroupsComplete();
	}

	@Override
	public List<SecTyp> getAllTypes() {
		return getSecTypDAO().getAllTypes();
	}

	@Override
	public void delete(SecRight right) {
		getSecRightDAO().delete(right);
	}

	@Override
	public boolean isRightinGroup(SecRight right, SecGroup group) {
		return getSecGrouprightDAO().isRightInGroup(right, group);
	}

	@Override
	public void saveOrUpdate(SecRight right) {
		if (right.isNew()) {

			SecRight newRight = getSecRightDAO().create();
			right.setRigId(newRight.getRigId());
		}
		getSecRightDAO().saveOrUpdate(right);
	}

	@Override
	public SecTyp getTypById(int typ_id) {
		return getSecTypDAO().getTypById(typ_id);
	}

	@Override
	public void saveOrUpdate(SecUserrole userRole) {
		if (userRole.isNew()) {

			SecUserrole newUserRole = getSecUserroleDAO().create();
			userRole.setUrrId(newUserRole.getUrrId());
		}
		getSecUserroleDAO().saveOrUpdate(userRole);
	}

	@Override
	public void saveOrUpdate(SecRolegroup roleGroup) {
		if (roleGroup.isNew()) {

			SecRolegroup newRoleGroup = getSecRolegroupDAO().create();
			roleGroup.setRlgId(newRoleGroup.getRlgId());
		}
		getSecRolegroupDAO().saveOrUpdate(roleGroup);
	}

	@Override
	public void saveOrUpdate(SecGroup group) {
		if (group.isNew()) {

			SecGroup newGroup = getSecGroupDAO().create();
			group.setGrpId(newGroup.getGrpId());
		}
		getSecGroupDAO().saveOrUpdate(group);
	}

	@Override
	public void saveOrUpdate(SecGroupright groupRight) {
		if (groupRight.isNew()) {

			SecGroupright newGroupRight = getSecGrouprightDAO().create();
			groupRight.setGriId(newGroupRight.getGriId());
		}
		getSecGrouprightDAO().saveOrUpdate(groupRight);
	}

	@Override
	public void delete(SecGroupright groupRight) {
		getSecGrouprightDAO().delete(groupRight);
	}

	@Override
	public SecGroupright getGroupRightByGroupAndRight(SecGroup group, SecRight right) {
		return getSecGrouprightDAO().getGroupRightByGroupAndRight(group, right);
	}

	@Override
	public SecRolegroup getRolegroupByRoleAndGroup(SecRole role, SecGroup group) {
		return getSecRolegroupDAO().getRolegroupByRoleAndGroup(role, group);
	}

	@Override
	public void delete(SecRolegroup roleGroup) {
		getSecRolegroupDAO().delete(roleGroup);
	}

	@Override
	public boolean isGroupInRole(SecGroup group, SecRole role) {
		return getSecRolegroupDAO().isGroupInRole(group, role);
	}

	@Override
	public SecUserrole getUserroleByUserAndRole(SecUser user, SecRole role) {
		return getSecUserroleDAO().getUserroleByUserAndRole(user, role);
	}

	@Override
	public void delete(SecUserrole userRole) {
		getSecUserroleDAO().delete(userRole);
	}

	@Override
	public boolean isUserInRole(SecUser user, SecRole role) {
		return getSecUserroleDAO().isUserInRole(user, role);

	}

	@Override
	public List<SecRight> getAllRights(List<Integer> list) {
		return getSecRightDAO().getAllRights(list);
	}

	@Override
	public List<SecRight> getRightsLikeRightName(String value) {
		return getSecRightDAO().getRightsLikeRightName(value);
	}

	@Override
	public List<SecRight> getRightsLikeRightNameAndType(String value, int type) {
		return getSecRightDAO().getRightsLikeRightNameAndType(value, type);
	}

	@Override
	public List<SecGroup> getGroupsLikeGroupName(String value) {
		return getSecGroupDAO().getGroupsLikeGroupName(value);
	}

	@Override
	public List<SecRole> getRolesLikeRoleName(String value) {
		return getSecRoleDAO().getRolesLikeRoleName(value);
	}

	@Override
	public void delete(SecGroup group) {
		getSecGroupDAO().delete(group);
	}

	@Override
	public List<SecRight> getGroupRightsByGroup(SecGroup group) {
		return getSecGrouprightDAO().getGroupRightsByGroup(group);
	}

	@Override
	public List<SecRight> getRightsLikeRightNameAndTypes(String value, List<Integer> list) {
		return getSecRightDAO().getRightsLikeRightNameAndTypes(value, list);
	}

}
