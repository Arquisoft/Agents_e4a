package asw.agents.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.dbManagement.model.Agent;
import asw.dbManagement.repository.AgentRepository;

@Service
public class InsertSampleData {
	
	@Autowired
	AgentRepository agentRepository;
	
	@PostConstruct
	public void init() {		
		agentRepository.save(new Agent("Paco Gómez", "paco@hotmail.com", "-3.7339100,40.4416800", 1, "13864928P", "123456"));
		
		agentRepository.save(new Agent("Pepe Fernández", "pepe@gmail.com", "1.7339100,26.4416800", 1, "87654321B", "123456"));
		
		agentRepository.save(new Agent("Carmen López", "carmen@yahoo.com", "5.7339100,48.4416800", 1, "11223344C", "123456"));
	}
}
