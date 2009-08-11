/**
 * 
 */
package de.forsthaus.backend.dao.impl;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;

import de.forsthaus.backend.dao.KundeDAO;
import de.forsthaus.backend.model.Branche;
import de.forsthaus.backend.model.KeyValuePair;
import de.forsthaus.backend.model.Kunde;

/**
 * @author bj
 * 
 */
public class KundeDAOImpl extends BasisfNextidviewImpl<Kunde> implements KundeDAO {

	private static Logger logger = Logger.getLogger(KundeDAOImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.daibutsu.backend.dao.KundeDAO#create(de.daibutsu.backend.model.Filiale
	 * )
	 */
	@Override
	public Kunde create() {
		Kunde kunde = new Kunde();
		kunde.setKunId(getNextId());

		return kunde;
	}

	@Override
	public Kunde getNewKunde() {
		return new Kunde();
	}

	@Override
	public void saveOrUpdate(Kunde kunde) {
		getHibernateTemplate().saveOrUpdate(kunde);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Kunde> getAlleKunden() {
//		logger.info("--> ");
//
//		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
//		criteria.addOrder(Order.asc("kunMatchcode")); // set the order
//
//		return getHibernateTemplate().findByCriteria(criteria);
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kunde> getAlleKunden(final int start, final int pageSize, final String fieldName, final boolean ascending) {
		logger.info("--> ");

		if (logger.isInfoEnabled()) {
			logger.info("Selektiere Kunden von Datensatz " + start + " bis " + (start + pageSize - 1));
		}

		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
		if (ascending) {
			criteria.addOrder(Order.asc(fieldName));
		} else {
			criteria.addOrder(Order.desc(fieldName));
		}
		return getHibernateTemplate().findByCriteria(criteria, start, pageSize);
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// // public List<Kunde> getAlleKunden(final int start, final int pageSize,
	// // final String fieldName, final boolean ascending) {
	// public List<Kunde> getAlleKunden(final int start, final int pageSize,
	// HibernateFieldComparator<?> comparator, boolean ascending) {
	// logger.info("--> ");
	//
	// if (logger.isInfoEnabled()) {
	// logger.info("Selektiere Kunden von Datensatz " + start + " bis " + (start
	// + pageSize - 1));
	// }
	//
	// DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
	// if (ascending) {
	// criteria.addOrder(Order.asc(comparator.getHibernateFieldName()));
	// } else {
	// criteria.addOrder(Order.desc(comparator.getHibernateFieldName()));
	// }
	// return getHibernateTemplate().findByCriteria(criteria, start, pageSize);
	// }

	/**
	 * Gibt die Anzahl aller Datensaetze der Tabelle "Kunden" zurueck
	 * 
	 * @return int
	 */
	public int getAnzahlKunden() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Kunde"));
	}

	/**
	 * Gibt einen Kunden-Datensatz der Tabelle "Kunde" zurueck, der mit dem der
	 * Kunden_ID uebereinstimmt
	 * 
	 * @param kun_id
	 *            (int)
	 * @return Kunde
	 */
	public Kunde getKundeByID(final long kun_id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
		criteria.add(Restrictions.eq("kunId", kun_id));

		return (Kunde) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	public Kunde getKundeByKunNr(String kun_nr) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
		criteria.add(Restrictions.eq("kunNr", kun_nr));

		return (Kunde) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
	}

	/**
	 * Gibt alle Kunden-Datensaetze der Tabelle "Kunde" zurueck, bei denen die
	 * uebergebene Zeichenfolge mittels 'like' in 'kun_matchcode' auftaucht.
	 * 
	 * 
	 * @param string
	 *            (String)
	 * @return Kunde (List)
	 */
	@SuppressWarnings("unchecked")
	public List<Kunde> getKundeLikeMatchcode(final String string) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
		criteria.add(Restrictions.ilike("kunMatchcode", string.toUpperCase(), MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);

	}

	/**
	 * Gibt alle Kunden-Datensaetze der Tabelle "Kunde" zurueck, bei denen die
	 * uebergebene Zeichenfolge mittels 'like' in 'kun_ort' auftaucht.
	 * 
	 * 
	 * @param string
	 *            (String)
	 * @return Kunde (List)
	 */
	@SuppressWarnings("unchecked")
	public List<Kunde> getKundeLikeOrt(final String string) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
		criteria.add(Restrictions.ilike("kunOrt", string.toUpperCase(), MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);

	}

	/**
	 * Gibt alle Kunden-Datensaetze der Tabelle "Kunde" zurueck, bei denen die
	 * uebergebene Zeichenfolge mittels 'like' in 'kun_name1' auftaucht.
	 * 
	 * 
	 * @param string
	 *            (String)
	 * @return Kunde (List)
	 */
	@SuppressWarnings("unchecked")
	public List<Kunde> getKundeLikeName1(final String string) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
		criteria.add(Restrictions.ilike("kunName1", string.toUpperCase(), MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);

	}

	/**
	 * Gibt alle Kunden-Datensaetze der Tabelle "Kunde" zurueck, bei denen die
	 * uebergebene Zeichenfolge mittels 'like' in 'kun_strasse' auftaucht.
	 * 
	 * 
	 * @param string
	 *            (String)
	 * @return Kunde (List)
	 */
	@SuppressWarnings("unchecked")
	public List<Kunde> getKundeLikeName2(final String string) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
		criteria.add(Restrictions.ilike("kunName2", string.toUpperCase(), MatchMode.ANYWHERE));

		return getHibernateTemplate().findByCriteria(criteria);

	}

	/**
	 * Gibt alle Kunden der Tabelle "Kunde" zurueck, bei denen der Wert mit
	 * 'kun_fil_id' uebereinstimmt.
	 * 
	 * @param i
	 *            (int)
	 * @return Kunde (List)
	 */
	@SuppressWarnings("unchecked")
	public List<Kunde> getKundeByFilialId(long id) {
		return getHibernateTemplate().find("from Kunde where kun_fil_id = ?", id);
	}

	/**
	 * Loescht einen Kunden aus der Tabelle "Kunde" anhand der ID
	 * 
	 * @param kun_id
	 *            (int)
	 * @param kun_fil_id
	 *            (int)
	 */
	public void deleteKundeByID(final long kun_id) {
		Kunde kunde = getKundeByID(kun_id);
		if (kunde != null) {
			delete(kunde);
		}
	}

	public void deleteKundeByKunNr(String kun_nr) {
		Kunde kunde = getKundeByKunNr(kun_nr);
		if (kunde != null) {
			delete(kunde);
		}
	}

	@Override
	public void delete(Kunde entity) throws DataAccessException {
		super.delete(entity);
	}

	@Override
	public void save(Kunde entity) throws DataAccessException {
		super.save(entity);
	}

	@Override
	public void initialize(Kunde proxy) {
		super.initialize(proxy);
	}

	@Override
	public void refresh(Kunde entity) {
		super.refresh(entity);
	}

	@Override
	public List getKundeByBranche(Branche branche) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
		criteria.add(Restrictions.eq("branche", branche));
		criteria.addOrder(Order.asc("kunMatchcode")); // set the order

		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<Kunde> getKundenByParams(List<KeyValuePair> list) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);

		List<Kunde> result = null; // init

		// check if empty
		if (list.isEmpty()) {
			result = null;
		}

		// if more than one param than construct the hql query
		String hqlFrom = " from Kunde as kunde where ";
		// get the first value

		KeyValuePair str = (KeyValuePair) list.get(0);
		String hqlWhere = " kunde." + str.getKey() + " like '%" + str.getValue() + "%'";

		for (int i = 1; i < list.size(); i++) {
			hqlWhere = hqlWhere + " and kunde." + list.get(i).getKey() + " like '%" + list.get(i).getValue() + "%'";
		}

		String hqlQuery = hqlFrom + hqlWhere;

		result = (List<Kunde>) getHibernateTemplate().find(hqlQuery);

		return result;
	}

	@Override
	public void testDeleteCustomersOver50000() {

		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
		criteria.add(Restrictions.gt("kunId", Long.valueOf("50000")));
		List<Kunde> list = getHibernateTemplate().findByCriteria(criteria);

		logger.debug("Count records for deleting : " + list.size());

		getHibernateTemplate().deleteAll((Collection<Kunde>) list);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getMaxKundenId() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Kunde.class);
		criteria.setProjection(Projections.projectionList().add(Projections.max("kunId")));

		List list = getHibernateTemplate().findByCriteria(criteria);
		String count = list.get(0).toString();

		return Integer.valueOf(count);
	}

}
