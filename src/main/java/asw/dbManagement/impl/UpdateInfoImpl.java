package asw.dbManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.dbManagement.UpdateInfo;
import asw.dbManagement.model.Agent;
import asw.dbManagement.repository.AgentRepository;

@Service
public class UpdateInfoImpl implements UpdateInfo {

	private AgentRepository repository;
	
	@Autowired
	public UpdateInfoImpl(AgentRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * Método que permite la actualización de la contraseña del Agente
	 * Se comprueba que las contraseñas no estén vacías, sean distintas y 
	 * la actual coincida con la del agente
	 */
	@Override
	public void updatePassword(Agent agente, String password, String newPassword) {
		
		if (password != null && newPassword != null && !(password.equals(newPassword))
				&& agente.getPassword().equals(password)) {
			agente.setPassword(newPassword);
			this.repository.save(agente);
		}
		
	}

	/**
	 * Método que permite la actualización del email del Agente
	 * Se comprueba que el email no esté vacío
	 */
	@Override
	public void updateEmail(Agent agente, String email) {
		if(email != null){
			agente.setEmail(email);
			this.repository.save(agente);
		}
	}

	/**
	 * Método que permite la actualización del nombre del Agente
	 * Se comprueba que el nombre no esté vacío
	 */
	@Override
	public void updateName(Agent agente, String nuevoNombre) {
		if(nuevoNombre != null){
			agente.setNombre(nuevoNombre);
			this.repository.save(agente);
		}
		
	}
/**
 * Método para actualizar la localizacion del agente por la nueva localizacion
 */
	@Override
	public void updateLocalizacion(Agent agente, String nuevaLocalizacion) {
		if(nuevaLocalizacion != null){
			agente.setLocalizacion(nuevaLocalizacion);
			this.repository.save(agente);
		}
		
	}

}
