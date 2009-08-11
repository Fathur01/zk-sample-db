package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.Auftrag;
import de.forsthaus.backend.model.Kunde;

public interface AuftragDAO {

	public Auftrag create(Kunde kunde);

	public Auftrag getNewAuftrag();

	public List<Auftrag> getAuftraegeByKunde(Kunde kunde);

	public int getAnzahlAuftraegeByKunde(Kunde kunde);

	public Auftrag getAuftragById(long auf_id);

	public Auftrag getAuftragByAufNr(String auf_nr);

	public void deleteAuftragByAufNr(String auf_nr);

	public void deleteAuftraegeByKunde(Kunde kunde);

	public void saveOrUpdate(Auftrag auftrag);

	public void delete(Auftrag auftrag);

	public void save(Auftrag auftrag);

	public void refresh(Auftrag auftrag);

	public void initialize(Auftrag auftrag);

	public Kunde getKundeForAuftrag(Auftrag auftrag);

}
