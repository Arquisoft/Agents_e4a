package asw.participants;

import org.springframework.http.ResponseEntity;

import asw.participants.webService.request.PeticionChangeEmailREST;
import asw.participants.webService.request.PeticionChangeNombreREST;
import asw.participants.webService.request.PeticionChangePasswordREST;
import asw.participants.webService.responses.RespuestaChangeInfoREST;

public interface ChangeInfo {
	/**
	 * Cambio de contraseña
	 *
	 * @param datos requeridos (login, password, newPassword)
	 * @return 
	 */
	public ResponseEntity<RespuestaChangeInfoREST> changePassword(PeticionChangePasswordREST datos);

	/**
	 * Cambio de email
	 * 
	 * @param datos requeridos (email, password, newEmail)
	 * @return respuesta en xml o json
	 */
	public ResponseEntity<RespuestaChangeInfoREST> changeEmail(PeticionChangeEmailREST datos);
	
	/**
	 * Cambio de nombre
	 * 
	 * @param datos requeridos (nombre, password, nuevoNombre)
	 * @return respuesta en xml o json
	 */
	public ResponseEntity<RespuestaChangeInfoREST> changeNombre(PeticionChangeNombreREST datos);
	
	/**
	 * Cambio de localizacion
	 * 
	 * @param datos requeridos (localizacion, password, nuevaLocalizacion)
	 * @return respuesta en xml o json
	 */
	public ResponseEntity<RespuestaChangeInfoREST> changeLocalizacion(PeticionChangeEmailREST datos);
}
