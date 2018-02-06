package asw.participants.factory;

import asw.participants.webService.responses.errors.ErrorResponse;
import asw.participants.webService.responses.errors.IncorrectPasswordErrorResponse;
import asw.participants.webService.responses.errors.KindDoNotMatchErrorResponse;
import asw.participants.webService.responses.errors.PasswordDoNotMatchErrorResponse;
import asw.participants.webService.responses.errors.RequiredEmailErrorResponse;
import asw.participants.webService.responses.errors.RequiredKindErrorResponse;
import asw.participants.webService.responses.errors.RequiredLocalizacionErrorResponse;
import asw.participants.webService.responses.errors.RequiredLoginErrorResponse;
import asw.participants.webService.responses.errors.RequiredNombreErrorResponse;
import asw.participants.webService.responses.errors.RequiredPasswordErrorResponse;
import asw.participants.webService.responses.errors.SameEmailErrorResponse;
import asw.participants.webService.responses.errors.SameLocalizacionErrorResponse;
import asw.participants.webService.responses.errors.SameNombreErrorResponse;
import asw.participants.webService.responses.errors.UnknownErrorResponse;
import asw.participants.webService.responses.errors.UserNotFoundResponse;
import asw.participants.webService.responses.errors.WrongEmailStyleErrorResponse;

//Creacion de los distintos tipos de error.
public class ErrorFactory {

	public static enum Errors {
		INCORRECT_PASSWORD,
		REQUIRED_EMAIL,
		REQUIRED_PASSWORD,
		USER_NOT_FOUND,
		WRONG_EMAIL_STYLE,
		INCORRECT_PASSWORD_DO_NOT_MATCH,
		SAME_EMAIL,
		REQUIRED_LOGIN,
		REQUIRED_KIND,
		INCORRECT_KIND_DO_NOT_MATCH,
		REQUIRED_NOMBRE,
		SAME_NOMBRE,
		REQUIRED_LOCALIZACION,
		SAME_LOCALIZACION
	}

	// Generar Constructor privado no queremos que se pueda tener varias
	// instancias de la clase.
	private ErrorFactory() {
	}

	public static ErrorResponse getError(Errors error) {
		switch (error) {
		case INCORRECT_PASSWORD:
			return new IncorrectPasswordErrorResponse();
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
		case SAME_LOCALIZACION:
			return new SameLocalizacionErrorResponse();	
		default:// en caso de no conocer el error.
			return new UnknownErrorResponse();
		}
	}

}
