package cybersoft.javabackend.girajava14vietan.role.service;

import java.util.List;

import javax.validation.Valid;

import cybersoft.javabackend.girajava14vietan.role.dto.RoleDTO;

public interface RoleService {

	List<RoleDTO> findAllDTO();

	RoleDTO create(RoleDTO dto);

}
