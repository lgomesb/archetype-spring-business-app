package ${package}.${artifactpkg}.domain.records;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ${domain}Record(UUID id, String name) {
    
}
