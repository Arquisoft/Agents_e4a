package asw.agents.webService.request;

public class PeticionChangeLocalizacionREST {
	private String login;
	private String localizacion;
	private String password;
	private String nuevaLocalizacion;
	
	public PeticionChangeLocalizacionREST() {

	}

	public PeticionChangeLocalizacionREST(String login, String localizacion, String password, String nuevaLocalizacion) {
		super();
		this.login=login;
		this.localizacion = localizacion;
		this.password = password;
		this.nuevaLocalizacion = nuevaLocalizacion;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNuevaLocalizacion() {
		return nuevaLocalizacion;
	}

	public void setNuevaLocalizacion(String nuevaLocalizacion) {
		this.nuevaLocalizacion = nuevaLocalizacion;
	}

}

