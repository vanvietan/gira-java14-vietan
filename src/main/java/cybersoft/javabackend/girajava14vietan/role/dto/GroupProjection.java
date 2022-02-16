package cybersoft.javabackend.girajava14vietan.role.dto;

import java.util.Set;
import java.util.UUID;

import cybersoft.javabackend.girajava14vietan.user.dto.UserProjection;

public interface GroupProjection {
	UUID getId();
 	String getName();
 	String getCode();
 	String getDescription();
 	UUID   getUserId();
 	String getUsername();
 	String getEmail();
 	String getFullname();
}
