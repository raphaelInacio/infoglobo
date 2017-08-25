package br.com.infoglobo.domain;

public enum Role {

	USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

	private String role;

	private Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public static String[] getRoles() {
		String roles[] = { Role.USER.getRole(), Role.ADMIN.getRole() };
		return roles;
	}

}
