package cybersoft.javabackend.girajava14vietan.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserDTO {
	
	private UUID id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(min = 4)
	private String password;
	
	@NotBlank
	@Size(min = 3)
	private String fullname;
}
