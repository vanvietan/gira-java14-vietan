package cybersoft.javabackend.girajava14vietan.role.dto;

import cybersoft.javabackend.girajava14vietan.role.dto.GroupDTO.GroupDTOBuilder;
import cybersoft.javabackend.girajava14vietan.role.model.GroupRole;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-26T04:19:45-0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
public class GroupMapperImpl implements GroupMapper {

    @Override
    public GroupDTO fromEntityToGroupDTO(GroupRole group) {
        if ( group == null ) {
            return null;
        }

        GroupDTOBuilder groupDTO = GroupDTO.builder();

        groupDTO.name( group.getName() );
        groupDTO.code( group.getCode() );
        groupDTO.description( group.getDescription() );

        return groupDTO.build();
    }
}
