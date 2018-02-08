package asw.participants.util;

import asw.Application;
import asw.dbManagement.model.Agent;
import asw.participants.factory.ErrorFactory;
import asw.participants.factory.ErrorFactory.Errors;
import asw.participants.webService.CsvReader;

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
	
	public static boolean isPasswordEmpty(String password) {
		if(password.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_PASSWORD);
		else
			return false;
	}
	
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
	public static boolean isParticipantNull(Agent participant){
		if (participant == null) {
			throw ErrorFactory.getError(Errors.USER_NOT_FOUND);
		}
		return false;		
	}
	
	public static boolean isPasswordCorrect(String password,Agent participant){
		if (!password.equals(participant.getPassword())) {
			throw ErrorFactory.getError(Errors.INCORRECT_PASSWORD_DO_NOT_MATCH);
		}
		return true;
	}
	
	public static boolean isSamePassword(String password, String password2){
		if (password.equals(password2)) {
			throw ErrorFactory.getError(Errors.INCORRECT_PASSWORD);
		}
		return true;
	}

	public static boolean isSameEmail(String email, String email2){
		if (email.equals(email2)) {
			throw ErrorFactory.getError(Errors.SAME_EMAIL);
		}
		return true;
	}
	
	public static boolean isSameNombre(String nombre, String nombre2){
		if (nombre.equals(nombre2)) {
			throw ErrorFactory.getError(Errors.SAME_NOMBRE);
		}
		return true;
	}

	public static boolean isLoginEmpty(String login) {
		if(login.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_LOGIN);
		else
			return false;
	}
	
	public static boolean isLocalizacionEmpty(String localizacion) {
		if(localizacion.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_LOCALIZACION);
		else
			return false;
		
	}

	public static boolean isKindEmpty(String kind) {
		if(kind.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_KIND);
		else
			return false;
		
	}

	public static boolean isKindCorrect(String kind,Agent participant){
		instancia=CsvReader.getInstance("src/main/resources/maestro.csv");
		//System.out.println(kind);
		//System.out.println(participant.getTipoCode());
		if(!instancia.checkType(kind, participant)) {
			throw ErrorFactory.getError(Errors.INCORRECT_KIND_DO_NOT_MATCH);
		}
		return true;
		/*if (!kind.equals(participant.getTipo())) {
			throw ErrorFactory.getError(Errors.INCORRECT_KIND_DO_NOT_MATCH);
		}
		return true;*/
	}

	public static boolean isSameLocalizacion(String localizacion, String nuevaLocalizacion) {
		if (localizacion.equals(nuevaLocalizacion)) {
			throw ErrorFactory.getError(Errors.SAME_LOCALIZACION);
		}
		return true;
		
	}

}
