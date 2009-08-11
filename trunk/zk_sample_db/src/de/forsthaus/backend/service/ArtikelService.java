package de.forsthaus.backend.service;

import de.forsthaus.backend.model.Artikel;

public interface ArtikelService {

	public Artikel getNewArtikel();

	public Artikel getArtikelById(long art_id);

	public void saveOrUpdate(Artikel artikel);

	public void delete(Artikel artikel);

}
