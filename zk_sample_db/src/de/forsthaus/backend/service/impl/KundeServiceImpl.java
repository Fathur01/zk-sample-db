/**
 * 
 */
package de.forsthaus.backend.service.impl;

import java.util.List;

import de.forsthaus.backend.dao.BrancheDAO;
import de.forsthaus.backend.dao.KundeDAO;
import de.forsthaus.backend.model.Branche;
import de.forsthaus.backend.model.KeyValuePair;
import de.forsthaus.backend.model.Kunde;
import de.forsthaus.backend.service.KundeService;

/**
 * @author bj
 * 
 */
public class KundeServiceImpl implements KundeService {

	private KundeDAO kundeDAO;

	public KundeDAO getKundeDAO() {
		return kundeDAO;
	}

	public void setKundeDAO(KundeDAO kundeDAO) {
		this.kundeDAO = kundeDAO;
	}

	private BrancheDAO brancheDAO;

	@Override
	public Kunde getNewKunde() {
		return getKundeDAO().getNewKunde();
	}

	@Override
	public List<Kunde> getAlleKunden(final int start, final int pageSize, final String fieldName, final boolean ascending) {
		return getKundeDAO().getAlleKunden(start, pageSize, fieldName, ascending);
	}

	@Override
	public void saveOrUpdate(Kunde kunde) {
		if (kunde.isNew()) {
			// Todo Filiale aus einlogg Methode holen

			Kunde newKunde = getKundeDAO().create();
			kunde.setKunId(newKunde.getKunId());

			// test
			if (kunde.getKunNr().isEmpty()) {
				kunde.setKunNr(String.valueOf(newKunde.getKunId()));
			}

		}
		getKundeDAO().saveOrUpdate(kunde);
	}

	@Override
	public void delete(Kunde kunde) {
		getKundeDAO().delete(kunde);
	}

	@Override
	public Kunde getKundeById(Long id) {
		Kunde kunde = getKundeDAO().getKundeByID(id);
		return kunde;
	}

	@Override
	public Kunde refresh(Kunde kunde) {
		/** lädt das Object neu */
		getKundeDAO().refresh(kunde);
		getKundeDAO().initialize(kunde);
		/** lädt in diesem Falle den zugehörigen Kunden nach */

		return kunde;
	}

	@Override
	public List<Kunde> getKundenByBranche(Branche branche) {
		return getKundeDAO().getKundeByBranche(branche);
	}

	@Override
	public Kunde getKundeByKunNr(String kun_nr) {
		Kunde kunde = getKundeDAO().getKundeByKunNr(kun_nr);
		return kunde;
	}

	@Override
	public List<Kunde> getKundenByParams(List<KeyValuePair> list) {
		return getKundeDAO().getKundenByParams(list);
	}

	@Override
	public int getMaxKundenId() {
		return getKundeDAO().getMaxKundenId();
	}

	@Override
	public int getAnzahlKunden() {
		return getKundeDAO().getAnzahlKunden();
	}

}
