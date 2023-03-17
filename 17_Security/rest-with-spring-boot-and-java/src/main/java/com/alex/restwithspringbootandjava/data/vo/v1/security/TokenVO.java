package com.alex.restwithspringbootandjava.data.vo.v1.security;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class TokenVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private Boolean authenticated;
	private Instant created;
	private Instant expiration;
	private String accessToke;
	private String refreshToken;

	public TokenVO() {
	}

	public TokenVO(String username, Boolean authenticated, Instant created, Instant expiration, String accessToke,
			String refreshToken) {
		super();
		this.username = username;
		this.authenticated = authenticated;
		this.created = created;
		this.expiration = expiration;
		this.accessToke = accessToke;
		this.refreshToken = refreshToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public Instant getExpiration() {
		return expiration;
	}

	public void setExpiration(Instant expiration) {
		this.expiration = expiration;
	}

	public String getAccessToke() {
		return accessToke;
	}

	public void setAccessToke(String accessToke) {
		this.accessToke = accessToke;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessToke, authenticated, created, expiration, refreshToken, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenVO other = (TokenVO) obj;
		return Objects.equals(accessToke, other.accessToke) && Objects.equals(authenticated, other.authenticated)
				&& Objects.equals(created, other.created) && Objects.equals(expiration, other.expiration)
				&& Objects.equals(refreshToken, other.refreshToken) && Objects.equals(username, other.username);
	}

}
