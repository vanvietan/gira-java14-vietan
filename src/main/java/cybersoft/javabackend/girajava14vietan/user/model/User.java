package cybersoft.javabackend.girajava14vietan.user.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cybersoft.javabackend.girajava14vietan.common.model.BaseEntity;
import cybersoft.javabackend.girajava14vietan.role.model.GroupRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "gira_user")
public class User extends BaseEntity{
	
	@Column(name = "username" , unique = true, updatable = false)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name= "email" , unique = true)
	private String email;
	
	@Column(name= "fullname")
	private String fullname;
	
	@Column(name = "displayName")
	private String displayName;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "account_status")
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;
	
	@Column(name = "facebookUrl")
	private String facebookUrl;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "hobbies")
	private String hobbies;
	
	@ManyToMany(mappedBy = "users")
	private Set<GroupRole> groups = new LinkedHashSet<>();
}
