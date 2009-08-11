package de.forsthaus.backend.dao;

import de.forsthaus.backend.model.Branche;

public interface BrancheDAO {

	public Branche create();

	public Branche getNewBranche();

	public Branche getBrancheByID(long bra_id);

	public Branche getBrancheByBraNr(String bra_nr);

	public Branche getBrancheByName(String braBezeichnung);

	public void saveOrUpdate(Branche branche);

	public void delete(Branche branche);

	public void save(Branche branche);

	public int getBrancheSize();

}
