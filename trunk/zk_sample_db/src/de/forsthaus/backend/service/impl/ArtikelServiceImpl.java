package de.forsthaus.backend.service.impl;

import de.forsthaus.backend.dao.ArtikelDAO;
import de.forsthaus.backend.model.Artikel;
import de.forsthaus.backend.service.ArtikelService;

public class ArtikelServiceImpl implements ArtikelService {

	private ArtikelDAO artikelDAO;

	public ArtikelDAO getArtikelDAO() {
		return artikelDAO;
	}

	public void setArtikelDAO(ArtikelDAO artikelDAO) {
		this.artikelDAO = artikelDAO;
	}

	@Override
	public Artikel getNewArtikel() {
		return getArtikelDAO().getNewArtikel();
	}

	@Override
	public void delete(Artikel artikel) {
		getArtikelDAO().delete(artikel);
	}

	@Override
	public Artikel getArtikelById(long art_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Artikel artikel) {
		if (artikel.isNew()) {
			// Erzeugen einer ID
			Artikel newArtikel = getArtikelDAO().create();
			// ID zum aktuellen Objekt hinzufügen
			artikel.setArtId(newArtikel.getArtId());
		}
		getArtikelDAO().saveOrUpdate(artikel);
	}

}
