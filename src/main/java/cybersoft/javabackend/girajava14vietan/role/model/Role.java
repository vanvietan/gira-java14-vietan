package cybersoft.javabackend.girajava14vietan.role.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cybersoft.javabackend.girajava14vietan.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "gira_role")
public class Role extends BaseEntity{
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "description" , nullable = false)
	private String description;
	
	@Column(name = "code" , unique = true)
	private String code;
	
	@ManyToMany(mappedBy = "roles")
	private Set<GroupRole> groups = new LinkedHashSet<>();
}
