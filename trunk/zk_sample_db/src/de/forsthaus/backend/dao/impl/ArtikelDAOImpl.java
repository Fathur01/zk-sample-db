package de.forsthaus.backend.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import de.forsthaus.backend.dao.ArtikelDAO;
import de.forsthaus.backend.model.Artikel;
import de.forsthaus.backend.model.KeyValuePair;

public class ArtikelDAOImpl extends BasisfNextidviewImpl<Artikel> implements ArtikelDAO {

	@Override
	public Artikel create() {
		Artikel artikel = new Artikel();
		artikel.setArtId(getNextId());

		return artikel;
	}

	@Override
	public Artikel getNewArtikel() {
		return new Artikel();
	}

	@Override
	public void delete(Artikel entity) throws DataAccessException {
		super.delete(entity);
	}

	@Override
	public Artikel getArtikelById(long art_id) {
		return (Artikel) getHibernateTemplate().get(Artikel.class, art_id);
	}

	@Override
	public void save(Artikel entity) throws DataAccessException {
		super.save(entity);
	}

	@Override
	public void saveOrUpdate(Artikel artikel) {
		getHibernateTemplate().saveOrUpdate(artikel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artikel> getArtikelLikeId(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Artikel.class);
		criteria.add(Restrictions.ilike("artNr", value, MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artikel> getArtikelLikeName(String value) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Artikel.class);
		criteria.add(Restrictions.ilike("artKurzbezeichnung", value, MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);

	}

	@Override
	public List<Artikel> getArtikelByParams(List<KeyValuePair> list) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Artikel.class);

		List<Artikel> result = null; // init

		// check if empty
		if (list.isEmpty()) {
			result = null;
		}

		// if more than one param than construct the hql query
		String hqlFrom = " from Artikel as artikel where ";
		// get the first value

		KeyValuePair str = (KeyValuePair) list.get(0);
		String hqlWhere = " artikel." + str.getKey() + " like '%" + str.getValue() + "%'";

		for (int i = 1; i < list.size(); i++) {
			hqlWhere = hqlWhere + " and artikel." + list.get(i).getKey() + " like '%" + list.get(i).getValue() + "%'";
		}

		String hqlQuery = hqlFrom + hqlWhere;

		result = (List<Artikel>) getHibernateTemplate().find(hqlQuery);

		return result;
	}

}
