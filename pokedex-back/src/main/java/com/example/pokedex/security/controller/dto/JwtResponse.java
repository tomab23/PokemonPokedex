package com.example.pokedex.security.controller.dto;

public class JwtResponse {

	private String token;

	private String tokenHeader;

	/**
	 *
	 */
	public JwtResponse() {
		super();
	}

	/**
	 * @param token
	 */
	public JwtResponse(String token, String tokenHeader) {
		super();
		this.token = token;
		this.tokenHeader = tokenHeader;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the tokenHeader
	 */
	public String getTokenHeader() {
		return tokenHeader;
	}

	/**
	 * @param tokenHeader the tokenHeader to set
	 */
	public void setTokenHeader(String tokenHeader) {
		this.tokenHeader = tokenHeader;
	}

}
