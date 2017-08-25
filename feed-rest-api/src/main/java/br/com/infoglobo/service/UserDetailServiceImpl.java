package br.com.infoglobo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.infoglobo.domain.User;
import br.com.infoglobo.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		try {

			User user = userRepository.findOne(name);

			if (user == null)
				throw new UsernameNotFoundException("Username" + name + "Not found!");

			return new User(user.getUsername(), user.getPassword(), user.getAuthorities().toArray(new String[user.getAuthorities().size()]));

		} catch (Exception e) {
			throw new UsernameNotFoundException("User Not found!");
		}
	}
}
