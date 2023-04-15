package com.pos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.pos.repository.IUserRepository;

@Component
public class PosUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {

		var usuario = userRepository.findOneByNickname(nickname)
				.orElseThrow(() -> new UsernameNotFoundException("not found nickname"));

		return new PosUserDetailsImpl(usuario);
//		if (!"admin".equals(nickname))
//			return null;
//
//		return User.builder().username("admin").password(myPassEncoder().encode("123")).roles().build();
	}

	public PasswordEncoder myPassEncoder() {
		return new BCryptPasswordEncoder();
	}

//	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder().encode("123"));
//	}

}
