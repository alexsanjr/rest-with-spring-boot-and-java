package com.alex.restwithspringbootandjava.securityJwt;

import java.time.Instant;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.alex.restwithspringbootandjava.data.vo.v1.security.TokenVO;
import com.auth0.jwt.algorithms.Algorithm;

import jakarta.annotation.PostConstruct;

@Service
public class JwtTokenProvider {
	
	@Value("${security.jwt.token.secret-key:secret}")
	private String secretKey = "secret";
	
	@Value("${security.jwt.token.expire-lenght:3600000}")
	private long validityInMilliseconds = 3600000; // 1h
	
	@Autowired
	UserDetailsService userDetailsService;
	
	Algorithm algorithm = null;
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secretKey.getBytes());
	}
	
	public TokenVO createAccessToken(String username, List<String> roles) {
		Instant now = Instant.now();
		Instant validity = now.plusMillis(validityInMilliseconds);
		String accessToken = getAccessToken(username, roles, now, validity);
		String refreshToken = getAccessToken(username, roles, now);
		return new TokenVO(username, true, now, validity, accessToken, refreshToken);
	}

	private String getAccessToken(String username, List<String> roles, Instant now) {
		
		return null;
	}

	private String getAccessToken(String username, List<String> roles, Instant now, Instant validity) {
		// TODO Auto-generated method stub
		return null;
	}
}
