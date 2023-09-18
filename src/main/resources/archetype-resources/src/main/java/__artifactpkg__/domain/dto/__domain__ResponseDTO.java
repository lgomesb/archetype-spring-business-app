package ${package}.${artifactpkg}.domain.dto;

import ${package}.${artifactpkg}.domain.records.${domain}Record;
import lombok.Builder;

import java.util.UUID;

public class ${domain}ResponseDTO extends ResponseDTO {

    public static ${domain}ResponseDTO create(${domain}Record ${artifactpkg}Record) {
       return ${domain}ResponseDTO.builder()
                .id(${artifactpkg}Record.id())
                .name(${artifactpkg}Record.name())
                .build();
    }

    @Builder
    public ${domain}ResponseDTO(UUID id, String name) {
        super();
        super.setId(id);
        super.setName(name);
    }
}
