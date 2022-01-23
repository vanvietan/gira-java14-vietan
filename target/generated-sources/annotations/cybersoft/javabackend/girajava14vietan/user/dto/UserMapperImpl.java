package cybersoft.javabackend.girajava14vietan.user.dto;

import cybersoft.javabackend.girajava14vietan.user.model.User;
import cybersoft.javabackend.girajava14vietan.user.model.User.UserBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-22T17:36:35-0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User createUserDtoToUserEntity(CreateUserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserBuilder<?, ?> user = User.builder();

        user.username( dto.getUsername() );
        user.password( dto.getPassword() );
        user.email( dto.getEmail() );
        user.fullname( dto.getFullname() );

        return user.build();
    }

    @Override
    public CreateUserDTO userEntityToCreateUserDTO(User entity) {
        if ( entity == null ) {
            return null;
        }

        CreateUserDTO createUserDTO = new CreateUserDTO();

        createUserDTO.setUsername( entity.getUsername() );
        createUserDTO.setEmail( entity.getEmail() );
        createUserDTO.setPassword( entity.getPassword() );
        createUserDTO.setFullname( entity.getFullname() );

        return createUserDTO;
    }
}
