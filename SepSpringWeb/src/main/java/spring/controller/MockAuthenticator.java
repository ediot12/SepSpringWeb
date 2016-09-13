package spring.controller;

import javax.naming.AuthenticationException;

public class MockAuthenticator implements Authenticator {

	@Override
	public void authenticate(String id, String password) throws AuthenticationException {
		// TODO Auto-generated method stub
		if (!id.equals("test")) {

			throw new AuthenticationException("invalid id " + id);
		}

	}

}
