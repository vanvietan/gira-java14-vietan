package cybersoft.javabackend.girajava14vietan.role.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14vietan.role.model.Role;

@RestController
public class RoleControllerImpl implements RoleController{

	@Override
	public ResponseEntity<List<Role>> getRoles() {
		return new ResponseEntity<>( null, HttpStatus.OK);
	}

}
