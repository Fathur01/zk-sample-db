/**
 * 
 */
package de.forsthaus.backend.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.AuftragDAO;
import de.forsthaus.backend.model.Auftrag;
import de.forsthaus.backend.model.Kunde;

/**
 * @author bj
 * 
 */
public class AuftragDAOImpl extends BasisfNextidviewImpl<Auftrag> implements AuftragDAO {

	@Override
	public Auftrag create(Kunde kunde) {
		Auftrag auftrag = new Auftrag();
		auftrag.setAufId(getNextId());
		auftrag.setKunde(kunde);

		return auftrag;
	}

	@Override
	public Auftrag getNewAuftrag() {
		return new Auftrag();
	}

	@Override
	public void saveOrUpdate(Auftrag auftrag) {
		getHibernateTemplate().saveOrUpdate(auftrag);
	}

	@Override
	public Auftrag getAuftragById(long auf_id) {
		return (Auftrag) getHibernateTemplate().get(Auftrag.class, auf_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Auftrag> getAuftraegeByKunde(Kunde kunde) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Auftrag.class);
		criteria.add(Restrictions.eq("kunde", kunde));

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getAnzahlAuftraegeByKunde(Kunde kunde) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Auftrag.class);

		criteria.add(Restrictions.eq("kunde", kunde));
		List<Auftrag> anzahl = getHibernateTemplate().findByCriteria(criteria);

		return anzahl.size();

	}

	@Override
	public Auftrag getAuftragByAufNr(String auf_nr) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Auftrag.class);
		criteria.add(Restrictions.eq("aufNr", auf_nr));

		return (Auftrag) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public void deleteAuftragByAufNr(String auf_nr) {
		Auftrag auftrag = getAuftragByAufNr(auf_nr);
		if (auftrag != null) {
			delete(auftrag);
		}
	}

	@Override
	public void deleteAuftraegeByKunde(Kunde kunde) {
		List<Auftrag> auftragList = getAuftraegeByKunde(kunde);
		if (auftragList != null) {
			delete(auftragList);
		}
	}

	@Override
	public void delete(Auftrag entity) throws DataAccessException {
		super.delete(entity);
	}

	@Override
	public void save(Auftrag entity) throws DataAccessException {
		super.save(entity);
	}

	@Override
	public void refresh(Auftrag entity) {
		super.refresh(entity);
	}

	@Override
	public void initialize(Auftrag proxy) {
		super.initialize(proxy);
	}

	@Override
	public Kunde getKundeForAuftrag(Auftrag auftrag) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);

		criteria.createAlias("auftrags", "au");
		criteria.add(Restrictions.eq("au.aufId", auftrag.getAufId()));

		return (Kunde) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}
}
