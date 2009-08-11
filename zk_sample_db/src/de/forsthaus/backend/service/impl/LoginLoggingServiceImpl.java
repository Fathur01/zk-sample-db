/**
 * 
 */
package de.forsthaus.backend.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import de.forsthaus.backend.dao.SecLoginlogDAO;
import de.forsthaus.backend.model.LoginStatus;
import de.forsthaus.backend.model.SecLoginlog;
import de.forsthaus.backend.service.LoginLoggingService;

/**
 * @author bj
 * 
 */
public class LoginLoggingServiceImpl implements LoginLoggingService {

	final private Logger logger = Logger.getLogger(getClass());

	private SecLoginlogDAO secLoginlogDAO;

	public SecLoginlogDAO getSecLoginlogDAO() {
		return secLoginlogDAO;
	}

	public void setSecLoginlogDAO(SecLoginlogDAO secLoginlogDAO) {
		this.secLoginlogDAO = secLoginlogDAO;
	}

	/**
	 * 
	 */
	public LoginLoggingServiceImpl() {
	}

	private Logger getLogger() {
		return this.logger;
	}

	@Override
	public void logAuthFail(String userName, String clientAddress, String sessionId) {
		getLogger().info("Login fehlgeschlagen für: " + userName + " Host:" + clientAddress + " SessionId: " + sessionId);

		saveLog(userName, clientAddress, sessionId, 0);
	}

	@Override
	public void logAuthPass(String userName, long userId, String clientAddress, String sessionId) {
		getLogger().info("Login ok für: " + userName + " -> UserID: " + userId + " Host:" + clientAddress + " SessionId: " + sessionId);

		saveLog(userName, clientAddress, sessionId, 1);
	}

	private void saveLog(String userName, String clientAddress, String sessionId, int status) {
		SecLoginlog log = getSecLoginlogDAO().getNewSecLoginlog();
		log.setLglLoginname(userName);
		log.setLglSessionid(sessionId);
		log.setLglIp(clientAddress);
		log.setLglLogtime(new Date());
		log.setLglStatusid(status);
		saveOrUpdate(log);
	}

	/*
	 * ++++++++++++++++++++++ Userlog +++++++++++++++++++++
	 */
	@Override
	public void delete(SecLoginlog secLoginlog) {
		getSecLoginlogDAO().delete(secLoginlog);
	}

	@Override
	public List<SecLoginlog> getAllLogs() {
		return getSecLoginlogDAO().getAllLogs();
	}

	@Override
	public List<SecLoginlog> getLogsByLoginname(String value) {
		return getSecLoginlogDAO().getLogsByLoginname(value);
	}

	@Override
	public SecLoginlog getNewSecLoginlog() {
		return getSecLoginlogDAO().getNewSecLoginlog();
	}

	@Override
	public SecLoginlog getLoginlogById(long log_Id) {
		// TODO Auto-generated method stub
		return getSecLoginlogDAO().getLoginlogById(log_Id);
	}

	@Override
	public void saveOrUpdate(SecLoginlog secLoginlog) {
		if (secLoginlog.isNew()) {

			SecLoginlog newSecLoginlog = getSecLoginlogDAO().create();
			secLoginlog.setLglId(newSecLoginlog.getLglId());
		}
		getSecLoginlogDAO().saveOrUpdate(secLoginlog);
	}

	@Override
	public List<LoginStatus> getAllTypes() {
		return getSecLoginlogDAO().getAllTypes();
	}

	@Override
	public LoginStatus getTypById(int typ_id) {
		return getSecLoginlogDAO().getTypById(typ_id);
	}

	@Override
	public List<SecLoginlog> getAllLogsForFailed() {
		return getSecLoginlogDAO().getAllLogsForFailed();
	}

	@Override
	public List<SecLoginlog> getAllLogsForSuccess() {
		return getSecLoginlogDAO().getAllLogsForSuccess();
	}

	@Override
	public List<SecLoginlog> getLogsByPeriod(Date dateFrom, Date dateTo) {
		return getSecLoginlogDAO().getLogsByPeriod(dateFrom, dateTo);
	}

}
