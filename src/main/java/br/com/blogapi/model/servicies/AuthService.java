package br.com.blogapi.model.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.blogapi.data.vo.v1.security.AccountCredentialsVO;
import br.com.blogapi.data.vo.v1.security.TokenVO;
import br.com.blogapi.model.entities.User;
import br.com.blogapi.model.repositories.UserRepository;
import br.com.blogapi.security.jwt.JwtTokenProvider;

@Service
public class AuthService {
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository repository;
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity signin(AccountCredentialsVO data) {
		try {
			String username = data.getUsername();
			String password = data.getPassword();
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			User user = repository.findByUsername(username);
			
			var tokenResponse = new TokenVO();
			
			if(user != null) {
				tokenResponse = tokenProvider.creatAccessToken(username, user.getRoles());
			}
			else {
				throw new UsernameNotFoundException("Username "+ username+ " not found!");
			}
			return ResponseEntity.ok(tokenResponse);
		} catch (Exception e) {
			throw new BadCredentialsException("Invalid username/password supplied!");
		}
	}
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity refreshToken(String username, String refreshToken) {
		User user = repository.findByUsername(username);
		
		var tokenResponse = new TokenVO();
		
		if(user != null) {
			tokenResponse = tokenProvider.refreshToken(refreshToken);
		}
		else {
			throw new UsernameNotFoundException("Username "+ username+ " not found!");
		}
		return ResponseEntity.ok(tokenResponse);

	}
}
