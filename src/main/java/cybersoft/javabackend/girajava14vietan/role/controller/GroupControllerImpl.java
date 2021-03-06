package cybersoft.javabackend.girajava14vietan.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.girajava14vietan.common.ResponseHandler;
import cybersoft.javabackend.girajava14vietan.role.dto.GroupDTO;
import cybersoft.javabackend.girajava14vietan.role.service.GroupRoleService;

@RestController
public class GroupControllerImpl implements GroupController{
	
	@Autowired
	private GroupRoleService service;
	
	@Override
	public ResponseEntity<Object> findGroups() {
		List<GroupDTO> result = service.findAll();
		
		return ResponseHandler.getResponse(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> create(GroupDTO dto, BindingResult result) {
		if(result.hasErrors()) {
			return ResponseHandler.getErrorResponse(result, HttpStatus.BAD_REQUEST);
		}
		
		GroupDTO createdGroup = service.create(dto);
		
		return ResponseHandler.getResponse(createdGroup, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> addUser(long GroupId, long userId) {
		service.addUser(GroupId, userId);
		
		return ResponseHandler.getResponse(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> removeUser(long GroupId, long userId) {
		service.removeUser(GroupId, userId);
		
		return ResponseHandler.getResponse(HttpStatus.OK);
	}

}
