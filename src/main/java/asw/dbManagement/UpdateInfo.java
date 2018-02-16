package asw.dbManagement;

import asw.dbManagement.model.Agent;

public interface UpdateInfo {
	/**
	 * Permite la solicitud de cambio de contraseña
	 */
	public void updatePassword(Agent agente, String password, String newPassword);
	
	public void updateEmail(Agent agente, String email);

	public void updateName(Agent agente, String nuevoNombre);

	public void updateLocalizacion(Agent agente, String nuevaLocalizacion);
}
