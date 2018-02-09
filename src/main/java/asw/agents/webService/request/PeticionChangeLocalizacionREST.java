package asw.agents.webService.request;

public class PeticionChangeLocalizacionREST {
	private String localizacion;
	private String password;
	private String nuevaLocalizacion;
	
	public PeticionChangeLocalizacionREST() {

	}

	public PeticionChangeLocalizacionREST(String localizacion, String password, String nuevaLocalizacion) {
		super();
		this.localizacion = localizacion;
		this.password = password;
		this.nuevaLocalizacion = nuevaLocalizacion;
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

