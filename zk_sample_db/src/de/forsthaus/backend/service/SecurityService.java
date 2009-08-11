package de.forsthaus.backend.service;

import java.util.List;

import de.forsthaus.backend.model.SecGroup;
import de.forsthaus.backend.model.SecGroupright;
import de.forsthaus.backend.model.SecRight;
import de.forsthaus.backend.model.SecRole;
import de.forsthaus.backend.model.SecRolegroup;
import de.forsthaus.backend.model.SecTyp;
import de.forsthaus.backend.model.SecUser;
import de.forsthaus.backend.model.SecUserrole;

public interface SecurityService {

	/* +++++ Security: Userroles +++++++ */
	public SecUserrole getNewSecUserrole();

	public void saveOrUpdate(SecUserrole userRole);

	public void delete(SecUserrole userRole);

	public List<SecUserrole> getAllUserRoles();

	public List<SecUserrole> getAllUserRolesComplete();

	public SecUserrole getUserroleByUserAndRole(SecUser user, SecRole role);

	public boolean isUserInRole(SecUser user, SecRole role);

	/* +++++ Security: Roles +++++++ */
	public SecRole getNewSecRole();

	public List<SecRole> getAllRoles();

	public void saveOrUpdate(SecRole role);

	public void delete(SecRole role);

	/* +++++ Security: RoleGroups +++++++ */
	public SecRolegroup getNewSecRolegroup();

	public void saveOrUpdate(SecRolegroup secRolegroup);

	public void delete(SecRolegroup roleGroup);

	public List<SecRolegroup> getAllRolegroups();

	public List<SecRolegroup> getAllRolegroupsComplete();

	public SecRolegroup getRolegroupByRoleAndGroup(SecRole role, SecGroup group);

	public boolean isGroupInRole(SecGroup group, SecRole role);

	/* +++++ Security: Groups +++++++ */

	public List<SecGroup> getAllGroups();

	public SecGroup getNewSecGroup();

	public void saveOrUpdate(SecGroup secGroup);

	public void delete(SecGroup group);

	/* +++++ Security: Rights +++++++ */
	public SecRight getNewSecRight();

	public void delete(SecRight right);

	public void saveOrUpdate(SecRight right);

	/**
	 * Get all rights. The result can limited by the type.<br>
	 * <br>
	 * 
	 * Int | Type <br>
	 * --------------------------<br>
	 * -1 | All (no filter) <br>
	 * 0 | Page <br>
	 * 1 | Menu Category <br>
	 * 2 | Menu Item <br>
	 * 3 | Method <br>
	 * 4 | DomainObject/Property <br>
	 * 5 | Tab <br>
	 * 6 | Components <br>
	 * 
	 */
	public List<SecRight> getAllRights(int type);

	public List<SecRight> getAllRights(List<Integer> list);

	public boolean isRightinGroup(SecRight right, SecGroup group);

	/* +++++ Security: Grouprights +++++++ */
	public List<SecGroupright> getAllGroupRights();

	public List<SecGroupright> getAllGroupRightsComplete();

	public SecGroupright getNewSecGroupright();

	public void delete(SecGroupright groupRight);

	public void saveOrUpdate(SecGroupright groupRight);

	/* +++++ Security: Security Typs +++++++ */
	public List<SecTyp> getAllTypes();

	public SecTyp getTypById(int typ_id);

	/* +++++++++++++++++++++++++++++++++++++++++++ */

	public SecGroupright getGroupRightByGroupAndRight(SecGroup group, SecRight right);

	public List<SecRight> getRightsLikeRightName(String value);

	public List<SecRight> getRightsLikeRightNameAndType(String value, int type);

	public List<SecGroup> getGroupsLikeGroupName(String value);

	public List<SecRole> getRolesLikeRoleName(String value);

	public List<SecRight> getGroupRightsByGroup(SecGroup group);

	public List<SecRight> getRightsLikeRightNameAndTypes(String value, List<Integer> list);

}
