package asw.dbManagement.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Agent")
public class Agent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(unique = true) private String identificador;
	private String nombre;
	@Column(nullable = false) private String email;	
	private String direccionPostal;
	private String username;
	public String tipo;
	private String password;
	private int type;
	
//	private String apellidos;
//	private Date fechaNacimiento;
//
//	private String nacionalidad;
//	private String dni;

	
		/**
		 * Constructor vacío (ya que es para mapear)
		 */
		Agent() {
		}

		/**
		 * Constructor
		 * 
		 * @param nombre
		 * @param localizacion
		 * @param email
		 * @param identificador
		 * @param tipo
		 * @param tipoCode
		 * @param password
		 */

		
		
		public Agent(String nombre,  String apellidos, String email, Date fechaNacimiento,
				String direccionPostal, String nacionalidad, String DNI,
				int tipoCode, String password, String identificador, String username) {
			super();
			this.nombre = nombre;
			//this.apellidos=apellidos;
			this.username=username;
			//this.fechaNacimiento=fechaNacimiento;
			this.direccionPostal = direccionPostal;
			this.email = email;
//			this.nacionalidad=nacionalidad;
//			this.dni=DNI;
			
			this.identificador = identificador;
			this.type = tipoCode;
			this.password = password;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getLocalizacion() {
			return direccionPostal;
		}

		public void setLocalizacion(String localizacion) {
			this.direccionPostal = localizacion;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getIdentificador() {
			return identificador;
		}

		public void setIdentificador(String identificador) {
			this.identificador = identificador;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String tipo) {
			this.username = tipo;
		}
		
		public String getKind() {
			return tipo;
		}

		public void setKind(String tipo) {
			this.tipo = tipo;
		}

		public int getTipoCode() {
			return type;
		}

		public void setTipoCode(int tipoCode) {
			this.type = tipoCode;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		

		public String getDireccionPostal() {
			return direccionPostal;
		}

		public void setDireccionPostal(String direccionPostal) {
			this.direccionPostal = direccionPostal;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

//		public String getApellidos() {
//			return apellidos;
//		}
//
//		public void setApellidos(String apellidos) {
//			this.apellidos = apellidos;
//		}
//
//		public Date getFechaNacimiento() {
//			return fechaNacimiento;
//		}
//
//		public void setFechaNacimiento(Date fechaNacimiento) {
//			this.fechaNacimiento = fechaNacimiento;
//		}
//
//		public String getNacionalidad() {
//			return nacionalidad;
//		}
//
//		public void setNacionalidad(String nacionalidad) {
//			this.nacionalidad = nacionalidad;
//		}
//
//		public String getDni() {
//			return dni;
//		}
//
//		public void setDni(String dni) {
//			this.dni = dni;
//		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
			return result;
		}
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Agent other = (Agent) obj;
			if (identificador == null) {
				if (other.identificador != null)
					return false;
			} else if (!identificador.equals(other.identificador))
				return false;
			return true;
		}
		
		

		@Override
		public String toString() {
			return "Agent [nombre=" + nombre + ", localizacion=" + direccionPostal + ", email=" + email
					+ ", identificador=" + identificador + ", tipo=" + tipo + ", tipoCode=" + type + ", password="
					+ password + "]";
		}

}
