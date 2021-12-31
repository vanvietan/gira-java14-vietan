package cybersoft.javabackend.girajava14vietan.role.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import cybersoft.javabackend.girajava14vietan.role.dto.RoleDTO;
import cybersoft.javabackend.girajava14vietan.role.dto.UpdateRoleDTO;
import cybersoft.javabackend.girajava14vietan.role.model.Role;

public interface RoleService {

	List<RoleDTO> findAllDTO();

	RoleDTO create(RoleDTO dto);

	Optional<Role> findByName(String roleName);

	Optional<Role> findByCode(String roleCode);

	RoleDTO updateRole(long id, UpdateRoleDTO dto);

	void deleteRole(long id);

}
