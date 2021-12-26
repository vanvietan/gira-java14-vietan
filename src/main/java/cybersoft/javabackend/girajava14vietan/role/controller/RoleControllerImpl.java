package cybersoft.javabackend.girajava14vietan.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14vietan.common.ResponseHandler;
import cybersoft.javabackend.girajava14vietan.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14vietan.role.service.RoleService;

@RestController
public class RoleControllerImpl implements RoleController{
	
	@Value("${api.role.name}")
	private String name;
	
	
	private RoleService service;
	
	public RoleControllerImpl(RoleService roleService) {
		service = roleService;
	}
	
	@Override
	public ResponseEntity<Object> getRoles() {
		List<RoleDTO> roles = service.findAllDTO();
		
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createRole(@Valid RoleDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getResponse(bindingResult.getAllErrors() , HttpStatus.BAD_REQUEST);
		}
		
		RoleDTO createdRole = service.create(dto);
		
		return ResponseHandler.getResponse(createdRole, HttpStatus.OK);
	}

}
