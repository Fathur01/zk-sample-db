package de.forsthaus.backend.service;

import de.forsthaus.backend.model.Branche;

public interface BrancheService {

	public Branche getNewBranche();

	Branche getBrancheById(long bra_id);

	void saveOrUpdate(Branche branche);

	void delete(Branche branche);
}
