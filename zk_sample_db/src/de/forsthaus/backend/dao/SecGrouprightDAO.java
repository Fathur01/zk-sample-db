package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.SecGroup;
import de.forsthaus.backend.model.SecGroupright;
import de.forsthaus.backend.model.SecRight;

public interface SecGrouprightDAO {

	public SecGroupright create();

	public SecGroupright getNewSecGroupright();

	public void saveOrUpdate(SecGroupright secGroupright);

	public void delete(SecGroupright secGroupright);

	public List<SecRight> getRightsByGroup(SecGroup group);

	public SecRight getRightById(long right_id);

	public List<SecGroupright> getAllGroupRights();

	public List<SecGroupright> getAllGroupRightsComplete();

	public boolean isRightInGroup(SecRight right, SecGroup group);

	public SecGroupright getGroupRightByGroupAndRight(SecGroup group, SecRight right);

	public List<SecRight> getGroupRightsByGroup(SecGroup group);

}
