package cybersoft.javabackend.girajava14vietan.role.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cybersoft.javabackend.girajava14vietan.role.dto.GroupDTO;

@RequestMapping("/api/groups")
public interface GroupController {
	
	@GetMapping
	public ResponseEntity<Object> findGroups();
	
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody GroupDTO dto, BindingResult result );
	
	@PostMapping("/{group-id}/add-user")
	public ResponseEntity<Object> addUser(
			@PathVariable ("group-id") long GroupId, 
			@RequestParam ("user-id")long userId );
	
	@PostMapping("/{group-id}/remove-user")
	public ResponseEntity<Object> removeUser(
			@PathVariable ("group-id") long GroupId, 
			@RequestParam ("user-id")long userId );
}
