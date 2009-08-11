package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.Branche;
import de.forsthaus.backend.model.KeyValuePair;
import de.forsthaus.backend.model.Kunde;

public interface KundeDAO {

	public Kunde create();

	public Kunde getNewKunde();

//	public List<Kunde> getAlleKunden();

	public List<Kunde> getAlleKunden(final int start, final int pageSize, final String fieldName, final boolean ascending);

	public int getAnzahlKunden();

	public Kunde getKundeByID(long kun_id);

	public Kunde getKundeByKunNr(String kun_nr);

	public List<Kunde> getKundeLikeMatchcode(String string);

	public List<Kunde> getKundeLikeOrt(String string);

	public List<Kunde> getKundeLikeName1(String string);

	public List<Kunde> getKundeLikeName2(String string);

	public List<Kunde> getKundeByFilialId(long id);

	public void deleteKundeByID(long kun_id);

	public void deleteKundeByKunNr(String kun_nr);

	public void saveOrUpdate(Kunde kunde);

	public void delete(Kunde kunde);

	public void save(Kunde kunde);

	public void initialize(Kunde kunde);

	public void refresh(Kunde entity);

	public List<Kunde> getKundeByBranche(Branche branche);

	public List<Kunde> getKundenByParams(List<KeyValuePair> list);

	public void testDeleteCustomersOver50000();

	public int getMaxKundenId();

}
