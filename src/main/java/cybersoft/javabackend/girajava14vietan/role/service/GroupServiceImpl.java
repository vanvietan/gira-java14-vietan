package cybersoft.javabackend.girajava14vietan.role.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.javabackend.girajava14vietan.common.exception.GiraEntityNotFoundException;
import cybersoft.javabackend.girajava14vietan.role.dto.GroupDTO;
import cybersoft.javabackend.girajava14vietan.role.dto.GroupMapper;
import cybersoft.javabackend.girajava14vietan.role.dto.GroupProjection;
import cybersoft.javabackend.girajava14vietan.role.model.GroupRole;
import cybersoft.javabackend.girajava14vietan.role.repository.GroupRepository;
import cybersoft.javabackend.girajava14vietan.user.model.User;
import cybersoft.javabackend.girajava14vietan.user.repository.UserRepository;

@Service
@Transactional
public class GroupServiceImpl implements GroupRoleService{
	
	@Autowired
	private GroupRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<GroupDTO> findAll() {
		List<GroupRole> groups = repository.findAll();
		return groups.stream()
				.map(r -> GroupMapper.INSTANCE.fromEntityToGroupDTO(r))
				.collect(Collectors.toList());
	}

	@Override
	public GroupDTO create(GroupDTO dto) {
		GroupRole group = GroupRole.builder()
				.code(dto.getCode())
				.name(dto.getName())
				.description(dto.getDescription())
				.build();
		GroupRole createdGroup = repository.save(group);
		
		return GroupMapper.INSTANCE.fromEntityToGroupDTO(group);
	}

	@Override
	public Optional<GroupRole> findByName(String roleName) {
		
		return repository.findByName(roleName);
	}

	@Override
	public void deleteRole(UUID id) {
		repository.deleteById(id);
		
	}

	@Override
	public void addUser(UUID groupId, UUID userId) {
		GroupRole group = null;
		try {
			 group = repository.getById(groupId);
		} catch(EntityNotFoundException e) {
			throw new GiraEntityNotFoundException("Group Role is not existed.");
		}
		
		Optional<User> userOpt = userRepository.findById(userId);
		User user = userOpt.orElseThrow(() -> new GiraEntityNotFoundException("User is not existed"));
		
		group.addUser(user);
		repository.flush();
//		repository.save(group);
		
	}

	@Override
	public void removeUser(UUID groupId, UUID userId) {
		GroupRole group = repository.findById(groupId)
				.orElseThrow(() -> new GiraEntityNotFoundException("Group is not existed"));
		
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new GiraEntityNotFoundException("User is not existed"));
		
		group.removeUser(user);
		repository.save(group);
	}
	
	@Override
 	@Transactional(readOnly = true)
 	public Set<GroupProjection> findAllDto() {
 		return repository.findAllDto();
 	}

}
