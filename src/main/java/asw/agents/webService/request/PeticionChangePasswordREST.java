package asw.agents.webService.request;

public class PeticionChangePasswordREST {

	private String login;
	private String password;
	private String newPassword;
	
	public PeticionChangePasswordREST() {

	}

	public PeticionChangePasswordREST(String login, String password, String newPassword) {
		super();
		this.password = password;
		this.newPassword = newPassword;
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getNewPassword() {
		return newPassword;
	}

}
