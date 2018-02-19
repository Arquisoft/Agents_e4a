package asw.dbManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.dbManagement.model.Agent;

@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {
	
	/**
	 * Método que devuelve el Agente, el cual es buscado por identificador
	 * en la base de datos
	 * @param identificador del Agente que se desea buscar
	 * @return El Agente con dicho identificador
	 */

	public Agent findById(String id);
	
}
