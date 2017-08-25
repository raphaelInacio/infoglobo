package br.com.infoglobo.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Document(collection = "user")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	public String id;
	@Indexed(unique = true)
	private String userName;
	private String password;
	private List<GrantedAuthority> grantedAuthorities;

	public User(String username, String password, String[] authorities) {
		this.userName = username;
		this.password = password;
		this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
