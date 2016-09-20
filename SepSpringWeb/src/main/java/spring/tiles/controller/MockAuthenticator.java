package spring.tiles.controller;

public class MockAuthenticator implements Authenticator{

	@Override
	public void authenticate(String id, String password) {
		// TODO Auto-generated method stub
		if(!id.equals("abc")){
			throw new AuthenticationException("invalid Id : " + id);
		}
	}

	
}
