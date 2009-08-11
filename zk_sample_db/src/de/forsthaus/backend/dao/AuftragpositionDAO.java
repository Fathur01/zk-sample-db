package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.Auftrag;
import de.forsthaus.backend.model.Auftragposition;

public interface AuftragpositionDAO {

	public Auftragposition create(Auftrag auftrag);

	public Auftragposition getNewAuftragposition();

	public List<Auftragposition> getAuftragpositionenByAuftrag(Auftrag auftrag);

	public int getAnzahlAuftragpositionenByAuftrag(Auftrag auftrag);

	public Auftragposition getAuftragpositionById(long aup_id);

	public void deleteAuftragpositionenByAuftrag(Auftrag auftrag);

	public void save(Auftragposition auftragposition);

	public void delete(Auftragposition auftragposition);

	public void saveOrUpdate(Auftragposition auftragposition);

}
