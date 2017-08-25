package br.com.infoglobo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.infoglobo.domain.Role;
import br.com.infoglobo.domain.User;
import br.com.infoglobo.json.UserJson;
import br.com.infoglobo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public ResponseEntity<User> createUser(UserJson user) {

		try {

			user.isValid();
			User newUser = new User(user.getUserName(), user.getPassword(), Role.getRoles());
			repository.save(newUser);
			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
