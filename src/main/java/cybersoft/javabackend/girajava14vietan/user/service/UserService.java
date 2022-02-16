package cybersoft.javabackend.girajava14vietan.user.service;

import cybersoft.javabackend.girajava14vietan.user.dto.CreateUserDTO;
import cybersoft.javabackend.girajava14vietan.user.model.User;
import java.util.UUID;

public interface UserService {
	
	User getUserById (UUID id);

	CreateUserDTO create( CreateUserDTO dto);
}
