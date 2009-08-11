package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.SecGroup;
import de.forsthaus.backend.model.SecRole;
import de.forsthaus.backend.model.SecRolegroup;

public interface SecRolegroupDAO {

	public SecRolegroup create();

	public SecRolegroup getNewSecRolegroup();

	public void saveOrUpdate(SecRolegroup roleGroup);

	public void delete(SecRolegroup roleGroup);

	public List<SecGroup> getGroupsByRole(SecRole role);

	public List<SecRolegroup> getAllRolegroups();

	public List<SecRolegroup> getAllRolegroupsComplete();

	public SecRolegroup getRolegroupByRoleAndGroup(SecRole role, SecGroup group);

	public boolean isGroupInRole(SecGroup group, SecRole role);

}
