package de.forsthaus.backend.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.BrancheDAO;
import de.forsthaus.backend.model.Branche;

public class BrancheDAOImpl extends BasisfNextidviewImpl<Branche> implements BrancheDAO {

	@Override
	public Branche create() {
		Branche branche = new Branche();
		branche.setBraId(getNextId());

		return branche;
	}

	@Override
	public Branche getNewBranche() {
		return new Branche();
	}

	@Override
	public Branche getBrancheByID(long bra_id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Branche.class);
		criteria.add(Restrictions.eq("braId", bra_id));

		return (Branche) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public Branche getBrancheByBraNr(String bra_nr) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Branche.class);
		criteria.add(Restrictions.eq("braNr", bra_nr));

		return (Branche) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public Branche getBrancheByName(String braBezeichnung) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Branche.class);
		criteria.add(Restrictions.eq("braBezeichnung", braBezeichnung));

		return (Branche) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	@Override
	public void saveOrUpdate(Branche branche) {
		getHibernateTemplate().saveOrUpdate(branche);
	}

	@Override
	public void delete(Branche entity) {
		super.delete(entity);
	}

	@Override
	public void save(Branche entity) {
		super.save(entity);
	}

	@Override
	public int getBrancheSize() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Branche.class);
		criteria.setProjection(Projections.rowCount());

		return DataAccessUtils.intResult(getHibernateTemplate().findByCriteria(criteria));
	}

}
