package wt.javaee.javaee.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public LoginBean() {
	}

	public LoginBean(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
