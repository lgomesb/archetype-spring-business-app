package ${package}.${artifactpkg}.domain.dto;

import ${package}.${artifactpkg}.domain.records.${domain}Record;
import lombok.Builder;

import java.util.UUID;

public class ${domain}ResponseDTO extends ResponseDTO {

    public static ${domain}ResponseDTO create(${domain}Record ${domain}Record) {
       return ${domain}ResponseDTO.builder()
                .id(${domain}Record.id())
                .name(${domain}Record.name())
                .build();
    }

    @Builder
    public ${domain}ResponseDTO(UUID id, String name) {
        super();
        super.setId(id);
        super.setName(name);
    }
}
