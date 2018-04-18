package asw.agents.factory;

import asw.agents.webService.responses.errors.ErrorResponse;
import asw.agents.webService.responses.errors.IncorrectPasswordErrorResponse;
import asw.agents.webService.responses.errors.KindDoNotMatchErrorResponse;
import asw.agents.webService.responses.errors.PasswordDoNotMatchErrorResponse;
import asw.agents.webService.responses.errors.RequiredEmailErrorResponse;
import asw.agents.webService.responses.errors.RequiredKindErrorResponse;
import asw.agents.webService.responses.errors.RequiredLocalizacionErrorResponse;
import asw.agents.webService.responses.errors.RequiredLoginErrorResponse;
import asw.agents.webService.responses.errors.RequiredNombreErrorResponse;
import asw.agents.webService.responses.errors.RequiredPasswordErrorResponse;
import asw.agents.webService.responses.errors.SameEmailErrorResponse;
import asw.agents.webService.responses.errors.SameLocalizacionErrorResponse;
import asw.agents.webService.responses.errors.SameNombreErrorResponse;
import asw.agents.webService.responses.errors.UnknownErrorResponse;
import asw.agents.webService.responses.errors.UserNotFoundResponse;
import asw.agents.webService.responses.errors.WrongDNIStyleErrorResponse;
import asw.agents.webService.responses.errors.WrongEmailStyleErrorResponse;
import asw.agents.webService.responses.errors.WrongLocationStyleErrorResponse;
import asw.dbManagement.model.Agent;

//Creacion de los distintos tipos de error.
public class ErrorFactory {

	public static enum Errors {
		INCORRECT_PASSWORD, WRONG_LOCALIZATION_STYLE, REQUIRED_EMAIL, REQUIRED_PASSWORD, USER_NOT_FOUND, WRONG_EMAIL_STYLE, INCORRECT_PASSWORD_DO_NOT_MATCH, SAME_EMAIL, REQUIRED_LOGIN, REQUIRED_KIND, INCORRECT_KIND_DO_NOT_MATCH, REQUIRED_NOMBRE, SAME_NOMBRE, REQUIRED_LOCALIZACION, WRONG_DNI_STYLE, SAME_LOCALIZACION

	}

	// Generar Constructor privado no queremos que se pueda tener varias
	// instancias de la clase.
	private ErrorFactory() {
	}

	public static ErrorResponse getError(Errors error, Agent agent) {
		switch (error) {
		case INCORRECT_KIND_DO_NOT_MATCH:
			return new KindDoNotMatchErrorResponse(agent);
		default:// en caso de no conocer el error.
			return new UnknownErrorResponse();
		}
	
		
	}

	public static ErrorResponse getError(Errors error) {
		switch (error) {
		case INCORRECT_PASSWORD:
			return new IncorrectPasswordErrorResponse();
		case WRONG_LOCALIZATION_STYLE:
			return new WrongLocationStyleErrorResponse();
		case REQUIRED_EMAIL:
			return new RequiredEmailErrorResponse();
		case REQUIRED_PASSWORD:
			return new RequiredPasswordErrorResponse();
		case USER_NOT_FOUND:
			return new UserNotFoundResponse();
		case WRONG_EMAIL_STYLE:
			return new WrongEmailStyleErrorResponse();
		case INCORRECT_PASSWORD_DO_NOT_MATCH:
			return new PasswordDoNotMatchErrorResponse();
		case SAME_EMAIL:
			return new SameEmailErrorResponse();
		case REQUIRED_LOGIN:
			return new RequiredLoginErrorResponse();
		case REQUIRED_KIND:
			return new RequiredKindErrorResponse();
		case INCORRECT_KIND_DO_NOT_MATCH:
			return new KindDoNotMatchErrorResponse();
		case REQUIRED_NOMBRE:
			return new RequiredNombreErrorResponse();
		case SAME_NOMBRE:
			return new SameNombreErrorResponse();
		case REQUIRED_LOCALIZACION:
			return new RequiredLocalizacionErrorResponse();
		case WRONG_DNI_STYLE:
			return new WrongDNIStyleErrorResponse();
		case SAME_LOCALIZACION:
			return new SameLocalizacionErrorResponse();
		default:// en caso de no conocer el error.
			return new UnknownErrorResponse();
		}
	}

}
