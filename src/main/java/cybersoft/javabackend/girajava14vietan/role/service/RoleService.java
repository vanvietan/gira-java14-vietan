package cybersoft.javabackend.girajava14vietan.role.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cybersoft.javabackend.girajava14vietan.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14vietan.role.dto.UpdateRoleDTO;
import cybersoft.javabackend.girajava14vietan.role.model.Role;

public interface RoleService {

	List<RoleDTO> findAllDTO();

	RoleDTO create(RoleDTO dto);

	Optional<Role> findByName(String roleName);

	Optional<Role> findByCode(String roleCode);

	RoleDTO updateRole(UUID id, UpdateRoleDTO dto);

	void deleteRole(UUID id);

}
