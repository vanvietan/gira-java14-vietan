package cybersoft.javabackend.girajava14vietan.role.service;

import java.util.List;
import java.util.Optional;

import cybersoft.javabackend.girajava14vietan.role.dto.GroupDTO;
import cybersoft.javabackend.girajava14vietan.role.model.GroupRole;


public interface GroupRoleService {
	List<GroupDTO> findAll();

	GroupDTO create(GroupDTO dto);

	Optional<GroupRole> findByName(String roleName);

	void deleteRole(long id);
	
	void addUser(long groupId, long userId);
	
	void removeUser(long groupId, long userId);
	
}
