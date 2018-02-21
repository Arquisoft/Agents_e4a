package asw.agents.webService.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import asw.dbManagement.model.Agent;

@XmlRootElement(name = "agent")
public class RespuestaInfoREST {	
	
	private String name;
	private String location;
	private String email;
	private String id;
	private String kind;
	private int kindCode;
	
	public RespuestaInfoREST() {}
	
	public RespuestaInfoREST(Agent agent){
		setName(agent.getNombre());
		setLocation(agent.getLocalizacion());
		setEmail(agent.getEmail());
		setId(agent.getIdentificador());
		setKind(agent.getKind());
		setKindCode(agent.getTipoCode());
	}


	public String getNombre() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	@XmlElement
	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	@XmlElement
	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getKindCode() {
		return kindCode;
	}

	@XmlElement
	public void setKindCode(int kindCode) {
		this.kindCode = kindCode;
	}

}
