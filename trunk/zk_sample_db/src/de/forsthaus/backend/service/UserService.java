package de.forsthaus.backend.service;

import java.util.List;

import de.forsthaus.backend.model.Language;
import de.forsthaus.backend.model.SecGroup;
import de.forsthaus.backend.model.SecRight;
import de.forsthaus.backend.model.SecRole;
import de.forsthaus.backend.model.SecUser;

public interface UserService {

	public SecUser getNewUser();

	List<SecUser> getAlleUser();

	void saveOrUpdate(SecUser user);

	void delete(SecUser user);

	public SecUser getUserByLoginname(final String userName);

	public List<SecRole> getRolesByUser(SecUser user);

	public List<SecRole> getAllRoles();

	public List<SecRight> getRightsByUser(SecUser user);

	public List<SecGroup> getGroupsByUser(SecUser user);

	public List<SecUser> getUserLikeLoginname(String value);

	public List<SecUser> getUserLikeLastname(String value);

	public List<SecUser> getUserLikeEmail(String value);

	public List<SecUser> getUserListByLoginname(String userName);

	public List<Language> getAllLanguages();

	public Language getLanguageById(String lan_id);

}
