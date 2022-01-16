package cybersoft.javabackend.girajava14vietan.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14vietan.common.ResponseHandler;
import cybersoft.javabackend.girajava14vietan.security.jwt.JwtUtils;

@RestController
public class AuthControllerImpl implements AuthController{
	
	@Autowired
	private JwtUtils jwtUtils;
	
//	@Override
//	public ResponseEntity<Object> createTemporaryToken(String name) {
//		String token = jwtUtils.generateFakeJwtToken(name);
//		return ResponseHandler.getResponse(token, HttpStatus.OK);
//	}

	@Override
	public ResponseEntity<Object> verifyFakeToken(String token) {
		boolean isValid = jwtUtils.validateJwtToken(token);
		return ResponseHandler.getResponse(isValid, HttpStatus.OK);
	}

}
