package de.forsthaus.backend.dao.impl;

import org.apache.log4j.Logger;

import de.forsthaus.backend.dao.GuestBookDAO;
import de.forsthaus.backend.model.GuestBook;

public class GuestBookDAOImpl extends BasisfNextidviewImpl<GuestBook> implements GuestBookDAO {

	private static Logger logger = Logger.getLogger(GuestBookDAOImpl.class);

	@Override
	public GuestBook create() {
		GuestBook guestBook = new GuestBook();
		guestBook.setGubId(getNextId());

		return guestBook;
	}

	@Override
	public GuestBook getNewGuestBook() {
		return new GuestBook();
	}

	@Override
	public void saveOrUpdate(GuestBook guestBook) {
		getHibernateTemplate().saveOrUpdate(guestBook);
	}

	@Override
	public void delete(GuestBook entity) {
		super.delete(entity);
	}

	@Override
	public void save(GuestBook entity) {
		super.save(entity);
	}

}
