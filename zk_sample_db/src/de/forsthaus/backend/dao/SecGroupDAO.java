package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.SecGroup;
import de.forsthaus.backend.model.SecGroupright;
import de.forsthaus.backend.model.SecRolegroup;
import de.forsthaus.backend.model.SecUser;

public interface SecGroupDAO {

	public SecGroup create();

	public SecGroup getNewSecGroup();

	public List<SecGroup> getAllGroups();

	public SecGroup getSecGroupById(long secGroup_id);

	public SecGroup getGroupByGroupRight(SecGroupright secGroupright);

	public SecGroup getGroupByRolegroup(SecRolegroup secRolegroup);

	public List<SecGroup> getGroupsByUser(SecUser user);

	public void saveOrUpdate(SecGroup secGroup);

	public void delete(SecGroup secGroup);

	public List<SecGroup> getGroupsLikeGroupName(String value);

}
