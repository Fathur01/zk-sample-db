package de.forsthaus.backend.service.impl;

import de.forsthaus.backend.dao.GuestBookDAO;
import de.forsthaus.backend.model.GuestBook;
import de.forsthaus.backend.service.GuestBookService;

public class GuestBookServiceImpl implements GuestBookService {

	private GuestBookDAO guestBookDAO;

	public GuestBookDAO getGuestBookDAO() {
		return guestBookDAO;
	}

	public void setGuestBookDAO(GuestBookDAO guestBookDAO) {
		this.guestBookDAO = guestBookDAO;
	}

	@Override
	public GuestBook getNewGuestBook() {
		return getGuestBookDAO().getNewGuestBook();
	}

	@Override
	public void delete(GuestBook guestBook) {
		getGuestBookDAO().delete(guestBook);
	}

	@Override
	public void saveOrUpdate(GuestBook guestBook) {
		// Bei Composite ID (also extra IDKlasse
		// prüfen == null, bei normalen PKs == 0
		if (guestBook.isNew()) {
			// Erzeugen einer ID
			GuestBook newGuestBook = getGuestBookDAO().create();
			// ID zum aktuellen Objekt hinzufügen
			guestBook.setGubId(newGuestBook.getGubId());
		}
		getGuestBookDAO().saveOrUpdate(guestBook);
	}

}
