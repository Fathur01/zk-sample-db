package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.SecGroupright;
import de.forsthaus.backend.model.SecRight;
import de.forsthaus.backend.model.SecUser;

public interface SecRightDAO {

	public SecRight create();

	public SecRight getNewSecRight();

	public List<SecRight> getAllRights(int type);

	public SecRight getRightById(long right_id);

	public void saveOrUpdate(SecRight right);

	public void delete(SecRight right);

	public List<SecRight> getRightsByGroupright(SecGroupright secGroupright);

	public List<SecRight> getRightsByUser(SecUser user);

	public List<SecRight> getAllRights(List<Integer> list);

	public List<SecRight> getRightsLikeRightName(String value);

	public List<SecRight> getRightsLikeRightNameAndType(String value, int type);

	public List<SecRight> getRightsLikeRightNameAndTypes(String value, List<Integer> list);

}
