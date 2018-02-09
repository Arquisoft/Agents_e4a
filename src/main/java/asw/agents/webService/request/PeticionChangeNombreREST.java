package asw.agents.webService.request;

public class PeticionChangeNombreREST {
	private String nombre;
	private String password;
	private String nuevoNombre;
	
	public PeticionChangeNombreREST() {

	}

	public PeticionChangeNombreREST(String nombre, String password, String nuevoNombre) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.nuevoNombre = nuevoNombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void SetNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNuevoNombre() {
		return nuevoNombre;
	}

	public void setNuevoNombre(String nuevoNombre) {
		this.nuevoNombre = nuevoNombre;
	}

}

