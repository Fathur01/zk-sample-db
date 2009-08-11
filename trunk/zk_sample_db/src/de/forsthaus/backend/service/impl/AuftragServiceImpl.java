/**
 * 
 */
package de.forsthaus.backend.service.impl;

import java.util.List;

import de.forsthaus.backend.dao.ArtikelDAO;
import de.forsthaus.backend.dao.AuftragDAO;
import de.forsthaus.backend.dao.AuftragpositionDAO;
import de.forsthaus.backend.dao.KundeDAO;
import de.forsthaus.backend.model.Artikel;
import de.forsthaus.backend.model.Auftrag;
import de.forsthaus.backend.model.Auftragposition;
import de.forsthaus.backend.model.KeyValuePair;
import de.forsthaus.backend.model.Kunde;
import de.forsthaus.backend.service.AuftragService;

/**
 * @author bj
 * 
 */
public class AuftragServiceImpl implements AuftragService {

	private AuftragDAO auftragDAO;
	private AuftragpositionDAO auftragpositionDAO;
	private KundeDAO kundeDAO;

	private ArtikelDAO artikelDAO;

	public void setArtikelDAO(ArtikelDAO artikelDAO) {
		this.artikelDAO = artikelDAO;
	}

	public ArtikelDAO getArtikelDAO() {
		return artikelDAO;
	}

	public KundeDAO getKundeDAO() {
		return kundeDAO;
	}

	public void setKundeDAO(KundeDAO kundeDAO) {
		this.kundeDAO = kundeDAO;
	}

	public AuftragDAO getAuftragDAO() {
		return auftragDAO;
	}

	public void setAuftragDAO(AuftragDAO auftragDAO) {
		this.auftragDAO = auftragDAO;
	}

	public AuftragpositionDAO getAuftragpositionDAO() {
		return auftragpositionDAO;
	}

	public void setAuftragpositionDAO(AuftragpositionDAO auftragPositionDAO) {
		this.auftragpositionDAO = auftragPositionDAO;
	}

	@Override
	public Auftrag getNewAuftrag() {
		return getAuftragDAO().getNewAuftrag();
	}

	@Override
	public List<Auftrag> getAlleAuftraegeByKunde(Kunde kunde) {
		List<Auftrag> result = getAuftragDAO().getAuftraegeByKunde(kunde);
		return result;
	}

	@Override
	public void saveOrUpdate(Auftrag auftrag) {
		// if (auftrag.getId().getAufId() == null) {
		if (auftrag.isNew()) {
			// Erzeugen einer ID
			Auftrag newAuftrag = getAuftragDAO().create(auftrag.getKunde());
			// ID zum aktuellen Objekt hinzufügen
			auftrag.setAufId(newAuftrag.getAufId());
		}
		getAuftragDAO().saveOrUpdate(auftrag);
	}

	@Override
	public void delete(Auftrag auftrag) {
		getAuftragDAO().delete(auftrag);
	}

	@Override
	public List<Auftragposition> getAuftragsPositionenByAuftrag(Auftrag auftrag) {
		/** lädt das Object neu */
		getAuftragDAO().refresh(auftrag);
		getAuftragDAO().initialize(auftrag);
		/** lädt in diesem Falle den zugehörigen Kunden nach */

		List<Auftragposition> result = getAuftragpositionDAO().getAuftragpositionenByAuftrag(auftrag);

		return result;
	}

	@Override
	public int getAnzahlAuftragpositionenByAuftrag(Auftrag auftrag) {
		int result = getAuftragpositionDAO().getAnzahlAuftragpositionenByAuftrag(auftrag);
		return result;
	}

	@Override
	public void initialize(Auftrag proxy) {
		getAuftragDAO().initialize(proxy);

	}

	@Override
	public Kunde getKundeForAuftrag(Auftrag auftrag) {
		return getAuftragDAO().getKundeForAuftrag(auftrag);
	}

	@Override
	public Auftrag getAuftragById(long auf_id) {
		return getAuftragDAO().getAuftragById(auf_id);
	}

	@Override
	public Auftragposition getNewAuftragposition() {
		return getAuftragpositionDAO().getNewAuftragposition();
	}

	@Override
	public void saveOrUpdate(Auftragposition auftragposition) {
		if (auftragposition.isNew()) {
			// Erzeugen einer ID
			Auftragposition newAuftragposition = getAuftragpositionDAO().create(auftragposition.getAuftrag());
			// ID zum aktuellen Objekt hinzufügen
			auftragposition.setAupId(newAuftragposition.getAupId());
		}
		getAuftragpositionDAO().saveOrUpdate(auftragposition);
	}

	@Override
	public void delete(Auftragposition auftragposition) {
		getAuftragpositionDAO().delete(auftragposition);
	}

	@Override
	public List<Artikel> getArtikelByParams(List<KeyValuePair> list) {
		return getArtikelDAO().getArtikelByParams(list);
	}

}
