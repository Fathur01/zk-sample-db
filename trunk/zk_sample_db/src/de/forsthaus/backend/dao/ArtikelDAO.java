package de.forsthaus.backend.dao;

import java.util.List;

import de.forsthaus.backend.model.Artikel;
import de.forsthaus.backend.model.KeyValuePair;

public interface ArtikelDAO {

	public Artikel create();

	public Artikel getNewArtikel();

	public Artikel getArtikelById(long art_id);

	public void saveOrUpdate(Artikel artikel);

	public void delete(Artikel artikel);

	public void save(Artikel artikel);

	public List<Artikel> getArtikelLikeId(String value);

	public List<Artikel> getArtikelLikeName(String value);

	public List<Artikel> getArtikelByParams(List<KeyValuePair> list);

}
