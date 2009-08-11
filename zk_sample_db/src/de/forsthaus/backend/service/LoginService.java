package de.forsthaus.backend.service;

import de.forsthaus.backend.model.SecUser;

public interface LoginService {

	SecUser getLoginUser(String usrLoginName, String usrPassword);

}
