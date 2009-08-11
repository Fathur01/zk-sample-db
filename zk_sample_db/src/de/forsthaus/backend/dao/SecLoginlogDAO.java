package de.forsthaus.backend.dao;

import java.util.Date;
import java.util.List;

import de.forsthaus.backend.model.LoginStatus;
import de.forsthaus.backend.model.SecLoginlog;

public interface SecLoginlogDAO {

	public SecLoginlog create();

	public SecLoginlog getNewSecLoginlog();

	public void saveOrUpdate(SecLoginlog loginLog);

	public void delete(SecLoginlog loginLog);

	public List<SecLoginlog> getAllLogs();

	public SecLoginlog getLoginlogById(long log_Id);

	public List<SecLoginlog> getLogsByLoginname(String value);

	public List<LoginStatus> getAllTypes();

	public LoginStatus getTypById(int typ_id);

	public List<SecLoginlog> getAllLogsForSuccess();

	public List<SecLoginlog> getAllLogsForFailed();

	public List<SecLoginlog> getLogsByPeriod(Date dateFrom, Date dateTo);
}
