package asw.agents.util;

import asw.Application;
import asw.agents.factory.ErrorFactory;
import asw.agents.factory.ErrorFactory.Errors;
import asw.agents.webService.CsvReader;
import asw.dbManagement.model.Agent;

public class Assert {
	
	public static CsvReader instancia;
	

	/**
	 * 
	 * @param email
	 * @return excepcion si esta vacio
	 */
	public static boolean isEmailEmpty(String email) {
		if(email.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_EMAIL);
		else
			return false;
	}
	/**
	 * Comprueba si la contraseña está vacia
	 * @param password
	 * @return
	 */
	public static boolean isPasswordEmpty(String password) {
		if(password.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_PASSWORD);
		else
			return false;
	}
	
	/**
	 * Comprueba si el nombre esta vacio
	 * @param nombre
	 * @return
	 */
	
	public static boolean isNombreEmpty(String nombre) {
		if(nombre.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_NOMBRE);
		else
			return false;
	}

	/**
	 * Comprobacion de si el correo es valido
	 * @param email
	 * @return true si es valido.
	 */
	public static boolean isEmailValid(String email) {
		String[] mailSplit = email.split("@");
		if (mailSplit.length != 2) {
			throw ErrorFactory.getError(Errors.WRONG_EMAIL_STYLE);
		}
		mailSplit = email.split("\\.");
		if (mailSplit.length != 2 || mailSplit[0].length() == 0 || mailSplit[1].length() == 0) {
			throw ErrorFactory.getError(Errors.WRONG_EMAIL_STYLE);
		}
		return true;
	}
	
	/**
	 * 
	 * @param participant
	 * @return devuelve false si no es null o excepcion
	 */
	public static boolean isParticipantNull(Agent agent){
		if (agent == null) {
			throw ErrorFactory.getError(Errors.USER_NOT_FOUND);
		}
		return false;		
	}
	
	/**
	 * Comprueba que la contraseña sea correcta
	 * @param password
	 * @param agent
	 * @return
	 */
	public static boolean isPasswordCorrect(String password,Agent agent){
		if (!password.equals(agent.getPassword())) {
			throw ErrorFactory.getError(Errors.INCORRECT_PASSWORD_DO_NOT_MATCH);
		}
		return true;
	}
	/**
	 * Comprueba si las dos contraseñas son iguales
	 * @param password
	 * @param password2
	 * @return
	 */
	public static boolean isSamePassword(String password, String password2){
		if (password.equals(password2)) {
			throw ErrorFactory.getError(Errors.INCORRECT_PASSWORD);
		}
		return true;
	}

	/**
	 * Devuelve true si los dos correos son iguales
	 * @param email
	 * @param email2
	 * @return
	 */
	public static boolean isSameEmail(String email, String email2){
		if (email.equals(email2)) {
			throw ErrorFactory.getError(Errors.SAME_EMAIL);
		}
		return true;
	}
	/**
	 * Método para comprobar que los nombres introducidos son iguales
	 * @param nombre
	 * @param nombre2
	 * @return
	 */
	public static boolean isSameNombre(String nombre, String nombre2){
		if (nombre.equals(nombre2)) {
			throw ErrorFactory.getError(Errors.SAME_NOMBRE);
		}
		return true;
	}

	/**
	 * Método que comprueba si el login está vacio
	 * @param login
	 * @return
	 */
	public static boolean isLoginEmpty(String login) {
		if(login.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_LOGIN);
		else
			return false;
	}
	
	/**
	 * Método que comprueba si la localización está vacia
	 * @param localizacion
	 * @return
	 */
	public static boolean isLocalizacionEmpty(String localizacion) {
		if(localizacion.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_LOCALIZACION);
		else
			return false;
		
	}

	/**
	 * Método para comprobar si el kind(tipo) esta vacio
	 * @param kind
	 * @return
	 */
	public static boolean isKindEmpty(String kind) {
		if(kind.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_KIND);
		else
			return false;
		
	}

	/**
	 * Método para compribar si el kind(tipo) es correcto
	 * @param kind
	 * @param agent
	 * @return
	 */
	public static boolean isKindCorrect(String kind,Agent agent){

		//System.out.println(kind);
		//System.out.println(participant.getTipoCode());
		if(!Application.instancia.checkType(kind, agent)) {
			throw ErrorFactory.getError(Errors.INCORRECT_KIND_DO_NOT_MATCH);
		}
		agent.setKind(kind.toLowerCase());
		return true;
		/*if (!kind.equals(participant.getTipo())) {
			throw ErrorFactory.getError(Errors.INCORRECT_KIND_DO_NOT_MATCH);
		}
		return true;*/
	}

	/**
	 * Método para comprobar que las dos localizaciones son iguales
	 * @param localizacion
	 * @param nuevaLocalizacion
	 * @return
	 */
	public static boolean isSameLocalizacion(String localizacion, String nuevaLocalizacion) {
		if (localizacion.equals(nuevaLocalizacion)) {
			throw ErrorFactory.getError(Errors.SAME_LOCALIZACION);
		}
		return true;
		
	}

}
