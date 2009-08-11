package de.forsthaus.backend.service;

import java.util.Date;
import java.util.List;

import de.forsthaus.backend.model.LoginStatus;
import de.forsthaus.backend.model.SecLoginlog;

public interface LoginLoggingService {

	/**
	 * 
	 * @param userName
	 *            Username, der sich angemeldet hat.
	 * @param userId
	 *            ID des Users.
	 * @param sessionId
	 * @param clientAddress
	 */
	void logAuthPass(String userName, long userId, String clientAddress, String sessionId);

	/**
	 * 
	 * @param userName
	 *            Username, der sich versucht hat anzumelden.
	 * @param sessionId
	 * @param clientAddress
	 */
	void logAuthFail(String userName, String clientAddress, String sessionId);

	/* +++++ Security: Userlog +++++++ */

	public SecLoginlog getNewSecLoginlog();

	public List<LoginStatus> getAllTypes();

	public LoginStatus getTypById(int typ_id);

	public void saveOrUpdate(SecLoginlog secLoginlog);

	public void delete(SecLoginlog secUserlog);

	public List<SecLoginlog> getAllLogs();

	public SecLoginlog getLoginlogById(long log_Id);

	public List<SecLoginlog> getLogsByLoginname(String value);

	public List<SecLoginlog> getAllLogsForSuccess();

	public List<SecLoginlog> getAllLogsForFailed();

	public List<SecLoginlog> getLogsByPeriod(Date dateFrom, Date dateTo);

}
