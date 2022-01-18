package cybersoft.javabackend.girajava14vietan.user.service;

import cybersoft.javabackend.girajava14vietan.user.dto.CreateUserDTO;
import cybersoft.javabackend.girajava14vietan.user.model.User;

public interface UserService {
	
	User getUserById (long id);

	CreateUserDTO create( CreateUserDTO dto);
}
