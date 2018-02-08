package asw.dbManagement.model;


import java.io.Serializable;

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
	private String localizacion;
	private String username;
	private String password;
	private int type;
	
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

		public Agent(String nombre, String localizacion, String email, int tipoCode, String identificador,
				 String username, String password) {
			super();
			this.identificador = identificador;
			this.nombre = nombre;
			this.localizacion = localizacion;
			this.email = email;	
			this.username = username;
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
			return localizacion;
		}

		public void setLocalizacion(String localizacion) {
			this.localizacion = localizacion;
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
			return "Agent [nombre=" + nombre + ", localizacion=" + localizacion + ", email=" + email
					+ ", identificador=" + identificador + ", username=" + username + ", tipoCode=" + type + ", password="
					+ password + "]";
		}

}
