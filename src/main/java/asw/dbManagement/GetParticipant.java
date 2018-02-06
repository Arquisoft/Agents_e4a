package asw.dbManagement;

import asw.dbManagement.model.Agent;

public interface GetParticipant {
	
	/**
	 * Permite la solicitud la de información para el usuario.
	 */
	public Agent getParticipant(String indentificador);
	
	
}
