package de.forsthaus.backend.dao;

import de.forsthaus.backend.model.GuestBook;

public interface GuestBookDAO {

	public GuestBook create();

	public GuestBook getNewGuestBook();

	public void saveOrUpdate(GuestBook guestBook);

	public void delete(GuestBook guestBook);

	public void save(GuestBook guestBook);

}
