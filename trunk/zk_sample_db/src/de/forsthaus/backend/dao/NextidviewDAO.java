package de.forsthaus.backend.dao;


public interface NextidviewDAO {

	/**
	 * Gibt die naechste Sequenz zurueck
	 * 
	 * @return NextID (Integer)
	 */
	public long getNextId();
}
