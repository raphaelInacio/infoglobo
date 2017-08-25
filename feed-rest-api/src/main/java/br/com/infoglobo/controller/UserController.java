package br.com.infoglobo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.infoglobo.domain.User;
import br.com.infoglobo.json.UserJson;
import br.com.infoglobo.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService serrvice;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> setUser(UserJson user) {
		return serrvice.createUser(user);
	}
}
