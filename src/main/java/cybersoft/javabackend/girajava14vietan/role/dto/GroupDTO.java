package cybersoft.javabackend.girajava14vietan.role.dto;

import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.girajava14vietan.role.validation.annotation.UniqueRoleCode;
import cybersoft.javabackend.girajava14vietan.role.validation.annotation.UniqueRoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDTO {
	
	@NotBlank(message="{role.name.not-blank}")
	@UniqueRoleName(message="This group name can not be used. Choose the another role name")
	private String name;
	
	@NotBlank(message = "{role.code.not-blank}")
	@UniqueRoleCode(message = "This group code can not be used. Choose the another role code")
	private String code;
	
	@NotBlank(message="{role.description.not-blank}")
	private String description;
}
