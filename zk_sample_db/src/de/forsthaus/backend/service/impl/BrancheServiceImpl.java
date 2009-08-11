package de.forsthaus.backend.service.impl;

import de.forsthaus.backend.dao.BrancheDAO;
import de.forsthaus.backend.model.Branche;
import de.forsthaus.backend.service.BrancheService;

public class BrancheServiceImpl implements BrancheService {

	private BrancheDAO brancheDAO;

	public BrancheDAO getBrancheDAO() {
		return brancheDAO;
	}

	public void setBrancheDAO(BrancheDAO brancheDAO) {
		this.brancheDAO = brancheDAO;
	}

	@Override
	public Branche getNewBranche() {
		return getBrancheDAO().getNewBranche();
	}

	@Override
	public void delete(Branche branche) {
		getBrancheDAO().delete(branche);
	}

	@Override
	public void saveOrUpdate(Branche branche) {
		if (branche.isNew()) {
			// create new ID
			Branche newBranche = getBrancheDAO().create();
			// ID zum aktuellen Objekt hinzufügen
			branche.setBraId(newBranche.getBraId());
		}
		getBrancheDAO().saveOrUpdate(branche);
	}

	@Override
	public Branche getBrancheById(long bra_id) {
		return getBrancheDAO().getBrancheByID(bra_id);
	}

}
