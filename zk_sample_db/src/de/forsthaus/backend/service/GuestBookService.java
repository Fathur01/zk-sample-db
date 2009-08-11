package de.forsthaus.backend.service;

import de.forsthaus.backend.model.GuestBook;

public interface GuestBookService {

	public GuestBook getNewGuestBook();

	void saveOrUpdate(GuestBook guestBook);

	void delete(GuestBook guestBook);

}
