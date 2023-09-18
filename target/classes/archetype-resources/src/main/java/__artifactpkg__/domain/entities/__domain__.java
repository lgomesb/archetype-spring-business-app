package ${package}.${artifactpkg}.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Table(name = "${artifactpkg}")
@Entity
public class ${domain} extends AbstractEntity {
    
    public ${domain}(String name) {
        super();
        super.setName(name);
    }
    
    @Builder()
    public ${domain}(UUID id, String name) {
        super();
        super.setId(id);
        super.setName(name);
    }
}
