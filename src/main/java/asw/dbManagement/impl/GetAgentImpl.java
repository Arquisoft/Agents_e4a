package asw.dbManagement.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.dbManagement.model.Agent;
import asw.dbManagement.repository.AgentRepository;


@Service
public class GetAgentImpl{
	
	@Autowired
	private AgentRepository repository;
	
	
	/**
	 * Método que devuelve el Agente buscado por identificador
	 * Hace uso del método findByIdentificador (mapeador)
	 */
	public Agent getAgent(String identificador) {
		
		return repository.findById(identificador);
	}
	
	public List<Agent> getAgents(){
		List<Agent> agents = new ArrayList<Agent>();
		repository.findAll().forEach(agents::add);
		return agents;
	}

}
