package asw.agents.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import asw.Application;
import asw.agents.factory.ErrorFactory;
import asw.agents.factory.ErrorFactory.Errors;
import asw.agents.webService.CsvReader;
import asw.dbManagement.model.Agent;

public class Assert {
	
	public static CsvReader instancia;
	

	/**
	 * Método que comprueba si el email está vaciio
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
	 * Método que comprueba si la contraseña está vacia
	 * @param password
	 * @return exception si esta vacio, false si no esta vacio
	 */
	
	public static boolean isPasswordEmpty(String password) {
		if(password.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_PASSWORD);
		else
			return false;
	}
	/**
	 * Método que comprueba si el nombre está vacio
	 * @param nombre
	 * @return excepcion si esta vacio, false si no esta vacio
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
	 * Metodo que comprueba si el agente es null
	 * @param agent
	 * @return devuelve false si no es null o excepcion
	 */
	public static boolean isAgentNull(Agent agent){
		if (agent == null) {
			throw ErrorFactory.getError(Errors.USER_NOT_FOUND);
		}
		return false;		
	}
	
	/**
	 * Metodo que comprueba que la contraseña sea correcta
	 * @param password
	 * @param agent
	 * @return excepcion si es incorrecta, true si es correcta
	 */
	public static boolean isPasswordCorrect(String password,Agent agent){
		if (!password.equals(agent.getPassword())) {
			throw ErrorFactory.getError(Errors.INCORRECT_PASSWORD_DO_NOT_MATCH);
		}
		return true;
	}
	
	/**
	 * Metodo que comprueba que las dos contraseñas sean iguales
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
	 * Metodo que compueba que los dos email son iguales
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
	 * Metodo que comprueba que los dos nombres son iguales 
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
	 * Metodo que comprueba si el campo login se encuentra vacio
	 * @param login
	 * @return
	 */
	public static boolean isLoginEmpty(String login) {
		if(login.trim().isEmpty())
			throw ErrorFactory.getError(Errors.REQUIRED_LOGIN);
		else
			return false;
	}
	/***
	 * Metodo que comprueba que la localizacion esta vacia
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
	 * Metodo que comprueba que la localizacion sea valida
	 * @param localizacion
	 * @return
	 */
	public static boolean isLocalizacionValid(String localizacion) {
		
		//Permite que la localización sea un campo Vacio
		if(localizacion.trim().isEmpty()){
			return true;
		}
		
		String[] locSplit=localizacion.split(",");
		
		if(locSplit.length !=2){
			throw ErrorFactory.getError(Errors.WRONG_LOCALIZATION_STYLE);
		}
		

		if(!locSplit[0].matches("-?\\d+(\\.\\d+)?")){
			throw ErrorFactory.getError(Errors.WRONG_LOCALIZATION_STYLE);
		}
		
		if(!locSplit[1].matches("-?\\d+(\\.\\d+)?")){
			throw ErrorFactory.getError(Errors.WRONG_LOCALIZATION_STYLE);
		}
		
		if(locSplit[0].matches("[a-zA-ZÑñ]")){
			throw ErrorFactory.getError(Errors.WRONG_LOCALIZATION_STYLE);
		}
		
		if(locSplit[1].matches("[a-zA-ZÑñ]")){
			throw ErrorFactory.getError(Errors.WRONG_LOCALIZATION_STYLE);
		}
		
		return true;
	}
	
	
	/**
	 * Comprueba si el Dni es correcto(Comprueba si la letra es acorde a los números). Los Dni actuales de los ejemplos no lo son.
	 * @param Dni
	 * @return
	 */
	public static boolean isDniValid(String Dni){
		Pattern pattern=Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher=pattern.matcher(Dni);
        if(matcher.matches()){
            String letra=matcher.group(2);
            String letras="TRWAGMYFPDXBNJZSQVHLCKE";
            int index=Integer.parseInt(matcher.group(1));
            index=index%23;
            String reference=letras.substring(index,index+1);
            if(reference.equalsIgnoreCase(letra)){
            	return true;
            }else{
            	throw ErrorFactory.getError(Errors.WRONG_DNI_STYLE);
            }
        }else{
        	throw ErrorFactory.getError(Errors.WRONG_DNI_STYLE);
        }
	}
	
	
	
	
	/**
	 * Metodo para comprobar si el kind(tipo) esta vacio
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
	 * Metodo que comprueba si el kind(tipo ) es correcto
	 * @param kind
	 * @param agent
	 * @return
	 */
	public static boolean isKindCorrect(String kind,Agent agent){
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
 * Metodo para comprobar si dos localizaciones son iguales
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
