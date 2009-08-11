package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.SecRole;
import de.forsthaus.backend.model.SecUser;
import de.forsthaus.backend.model.SecUserrole;

public interface SecUserroleDAO {

	public SecUserrole create();

	public SecUserrole getNewSecUserrole();

	public void saveOrUpdate(SecUserrole secUserrole);

	public void delete(SecUserrole secUserrole);

	public List<SecUserrole> getAllUserRoles();

	public List<SecUserrole> getAllUserRolesComplete();

	public SecUserrole getUserroleByUserAndRole(SecUser user, SecRole role);

	public boolean isUserInRole(SecUser user, SecRole role);

}
