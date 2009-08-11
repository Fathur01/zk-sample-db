/**
 * 
 */
package de.forsthaus.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.AuftragpositionDAO;
import de.forsthaus.backend.model.Auftrag;
import de.forsthaus.backend.model.Auftragposition;

/**
 * @author bj
 * 
 */

public class AuftragpositionDAOImpl extends BasisfNextidviewImpl<Auftragposition> implements AuftragpositionDAO {
	@Override
	public Auftragposition create(Auftrag auftrag) {
		Auftragposition auftragposition = new Auftragposition();
		auftragposition.setAupId(getNextId());
		auftragposition.setAuftrag(auftrag);

		return auftragposition;

	}

	@Override
	public Auftragposition getNewAuftragposition() {
		return new Auftragposition();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Auftragposition> getAuftragpositionenByAuftrag(Auftrag auftrag) {
		/** initialize() lädt die entsprechenden Daten nach. */
		return new ArrayList<Auftragposition>(auftrag.getAuftragpositions());
	}

	@Override
	public int getAnzahlAuftragpositionenByAuftrag(Auftrag auftrag) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Auftragposition.class);
		criteria.add(Restrictions.eq("auftrag", auftrag));
		criteria.setProjection(Projections.rowCount());
		return DataAccessUtils.intResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public Auftragposition getAuftragpositionById(long aup_id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Auftragposition.class);
		criteria.add(Restrictions.eq("aupId", aup_id));

		return (Auftragposition) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public void deleteAuftragpositionenByAuftrag(Auftrag auftrag) {
		List<Auftragposition> auftragpositionen = getAuftragpositionenByAuftrag(auftrag);
		if (auftragpositionen != null) {
			delete(auftragpositionen);
		}
	}

	@Override
	public void save(Auftragposition entity) throws DataAccessException {
		super.save(entity);
	}

	@Override
	public void delete(Auftragposition entity) throws DataAccessException {
		super.delete(entity);

	}

	@Override
	public void saveOrUpdate(Auftragposition auftragposition) {
		getHibernateTemplate().saveOrUpdate(auftragposition);
	}

}
