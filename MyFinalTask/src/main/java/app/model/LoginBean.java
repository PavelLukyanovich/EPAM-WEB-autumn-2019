package app.model;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;

	public String getUsername() {
		return login;
	}

	public void setUsername(String username) {
		this.login = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
