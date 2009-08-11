package de.forsthaus.backend.dao.impl;

import de.forsthaus.backend.dao.NextidviewDAO;
import de.forsthaus.backend.model.Nextidview;

public class NextidviewDEMODAOImpl extends BasisDAO<Nextidview> implements NextidviewDAO {

	// init the primary Key ID value
	private Long id = new Long(100000);

	/**
	 * Gives back the next primary key id. <br>
	 * Here: For the inMemory H2 Demo Database we use a variable <br>
	 * as the ID. <br>
	 * 
	 * @return NextID (Integer)
	 */
	@SuppressWarnings("unchecked")
	public long getNextId() {
		setId(id + 1);
		return getId();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
