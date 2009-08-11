package de.forsthaus.backend.service;

import java.util.List;

import de.forsthaus.backend.model.Artikel;
import de.forsthaus.backend.model.Auftrag;
import de.forsthaus.backend.model.Auftragposition;
import de.forsthaus.backend.model.KeyValuePair;
import de.forsthaus.backend.model.Kunde;

public interface AuftragService {

	public Auftrag getNewAuftrag();

	List<Auftrag> getAlleAuftraegeByKunde(Kunde kunde);

	void saveOrUpdate(Auftrag auftrag);

	void delete(Auftrag auftrag);

	// AuftragPositionen
	List<Auftragposition> getAuftragsPositionenByAuftrag(Auftrag auftrag);

	int getAnzahlAuftragpositionenByAuftrag(Auftrag auftrag);

	public void initialize(Auftrag proxy);

	public Kunde getKundeForAuftrag(Auftrag auftrag);

	public Auftrag getAuftragById(long auf_id);

	public Auftragposition getNewAuftragposition();

	public void saveOrUpdate(Auftragposition auftragposition);

	public void delete(Auftragposition auftragposition);

	public List<Artikel> getArtikelByParams(List<KeyValuePair> list);

}
