package com.gl.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.gl.entity.User;

public class MyUserDetails implements UserDetails {

	User u;

	public MyUserDetails(User u) {
		super();
		this.u = u;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		String roles[] = u.getRoles().split(",");
		Arrays.stream(roles).forEach(role -> list.add(new SimpleGrantedAuthority(role)));
		return list;
	}

	@Override
	public String getPassword() {

		return u.getPassword();
	}

	@Override
	public String getUsername() {

		return u.getUsername();
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
