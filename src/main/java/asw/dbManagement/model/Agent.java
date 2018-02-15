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
	private String localizacion;
	private String username;
	public String tipo;
	private int tipoCode;
	private String password;

	
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
		 * @param kindCode
		 * @param password
		 */		
		public Agent(String nombre, String email, String localizacion, int tipoCode,  String identificador, String password) {
			super();
			
			this.nombre = nombre;
			this.email = email;
			this.localizacion=localizacion;
			this.tipoCode = tipoCode;
			this.identificador = identificador;
			this.username=identificador;
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
		
		public String getKind() {
			return tipo;
		}

		public void setKind(String tipo) {
			this.tipo = tipo;
		}

		public int getTipoCode() {
			return tipoCode;
		}

		public void setTipoCode(int tipoCode) {
			this.tipoCode = tipoCode;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		

		public int getType() {
			return tipoCode;
		}

		public void setType(int type) {
			this.tipoCode = type;
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
					+ ", identificador=" + identificador + ", tipo=" + tipo + ", tipoCode=" + tipoCode + ", password="
					+ password + "]";
		}

}
