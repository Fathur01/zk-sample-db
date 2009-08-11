package de.forsthaus.backend.service;

import java.util.List;

import de.forsthaus.backend.model.Branche;
import de.forsthaus.backend.model.KeyValuePair;
import de.forsthaus.backend.model.Kunde;

public interface KundeService {

	public Kunde getNewKunde();

	public List<Kunde> getAlleKunden(int start, int pageSize, final String fieldName, final boolean ascending);

	void saveOrUpdate(Kunde kunde);

	void delete(Kunde kunde);

	Kunde getKundeById(Long id);

	// test zum nachladen zugehörigen Branche
	Kunde refresh(Kunde kunde);

	List<Kunde> getKundenByBranche(Branche branche);

	Kunde getKundeByKunNr(String kun_nr);

	public List<Kunde> getKundenByParams(List<KeyValuePair> list);

	public int getMaxKundenId();

	public int getAnzahlKunden();

}
