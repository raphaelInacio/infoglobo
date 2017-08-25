package br.com.infoglobo.json;

import lombok.Data;

@Data
public class UserJson {
	
	private String userName;
	private String password;

	public void isValid() {
		if (userName.equals("") || userName == null)
			throw new IllegalArgumentException("Parametro inválido");

		if (password.equals("") || password == null)
			throw new IllegalArgumentException("Parametro inválido");
	}
}
