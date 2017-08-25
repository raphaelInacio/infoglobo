package br.com.infoglobo.service;

import org.springframework.http.ResponseEntity;

import br.com.infoglobo.domain.User;
import br.com.infoglobo.json.UserJson;

public interface UserService {
	public ResponseEntity<User> createUser(UserJson user);
}
