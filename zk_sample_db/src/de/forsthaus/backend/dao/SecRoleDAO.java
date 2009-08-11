package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.SecRole;
import de.forsthaus.backend.model.SecUser;

public interface SecRoleDAO {

	public SecRole create();
	
	public SecRole getNewSecRole();

	public void saveOrUpdate(SecRole secRole);

	public void delete(SecRole secRole);

	public List<SecRole> getAllRoles();

	public SecRole getRoleById(long role_Id);

	public List<SecRole> getRolesByUser(SecUser user);

	public List<SecRole> getRolesLikeRoleName(String value);

}
