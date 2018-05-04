package asw.dbManagement;

import java.util.List;

import asw.dbManagement.model.Agent;

public interface GetAgent {
	
	public Agent getAgent(String identificador);
	
	public List<Agent> getAgents();

}
