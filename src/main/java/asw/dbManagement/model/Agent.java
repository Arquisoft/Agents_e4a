package asw.dbManagement.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Agent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(unique = true)
	private String id;
	private String nombre;
	private String email;	
	private String localizacion;
	@Transient
	private String tipo;
	private int type;
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
		 * @param email
		 * @param localizacion 
		 * @param kindCode	
		 * @param identificador	 
		 * @param password
		 */		
		public Agent(String nombre, String email, String localizacion, int type,  String identificador, String password) {
			super();			
			this.nombre = nombre;
			this.email = email;
			this.localizacion=localizacion;
			this.type = type;
			this.id = identificador;
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
			return id;
		}

		public void setIdentificador(String identificador) {
			this.id = identificador;
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
		

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
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
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Agent [id=" + id + ", nombre=" + nombre + ", email=" + email + ", localizacion=" + localizacion
					+ ", tipo=" + tipo + ", type=" + type + ", password=" + password + "]";
		}
	

}
