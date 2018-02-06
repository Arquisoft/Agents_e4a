package asw.dbManagement.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Participant")
public class Agent {

	// Id generado automáticamente para diferenciar cada uno (para mapear)
	@Id
	@GeneratedValue
	private Long id;

	// Atributos del participante
		private String nombre;
		private String localizacion;
		@Column(nullable = false)
		private String email;
		@Column(unique = true)
		private String identificador;
		private String tipo;
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
		 * @param tipoCode
		 * @param password
		 */

		public Agent(String nombre, String localizacion, String email, String identificador, String tipo,
				int tipoCode, String password) {
			super();
			this.nombre = nombre;
			this.localizacion = localizacion;
			this.email = email;
			this.identificador = identificador;
			this.tipo = tipo;
			this.tipoCode = tipoCode;
			this.password = password;
		}

		public Long getId() {
			return id;
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

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
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
			return "Participant [nombre=" + nombre + ", localizacion=" + localizacion + ", email=" + email
					+ ", identificador=" + identificador + ", tipo=" + tipo + ", tipoCode=" + tipoCode + ", password="
					+ password + "]";
		}

}
