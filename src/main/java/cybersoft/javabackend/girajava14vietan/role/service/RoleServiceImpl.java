package cybersoft.javabackend.girajava14vietan.role.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.girajava14vietan.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14vietan.role.model.Role;
import cybersoft.javabackend.girajava14vietan.role.repository.RoleRepository;
import cybersoft.javabackend.girajava14vietan.role.util.RoleConverter;

@Service
public class RoleServiceImpl implements RoleService{
	private RoleRepository repository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		repository = roleRepository;
	}

	@Override
	public List<RoleDTO> findAllDTO() {
		List<Role> roles = repository.findAll();
		

		return RoleConverter.toRoleDTOs(roles);
	}

	@Override
	public RoleDTO create(RoleDTO dto) {
		Role role = RoleConverter.toRole(dto);
		
		Role createdRole = repository.save(role);
		
		return RoleConverter.toRoleDTO(createdRole);
	}

}
