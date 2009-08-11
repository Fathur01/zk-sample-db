package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.SecUser;

public interface UserDAO {

	public SecUser create();

	public SecUser getNewSecUser();

	public List<SecUser> getAlleUser();

	public SecUser getUserByID(long usr_id);

	public SecUser getUserByFiluserNr(String usr_nr);

	public SecUser getUserByNameAndPassword(String userName, String passWord);

	public void saveOrUpdate(SecUser user);

	public void delete(SecUser user);

	public void save(SecUser user);

	public SecUser getUserByLoginname(final String userName);

	public List<SecUser> getUserLikeLastname(String value);

	public List<SecUser> getUserLikeLoginname(String value);

	public List<SecUser> getUserLikeEmail(String value);

	public List<SecUser> getUserListByLoginname(String userName);
}
