package ${package}.${artifactpkg}.repositories;

import ${package}.${artifactpkg}.domain.entities.${domain};
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ${domain}Repository extends JpaRepository<${domain}, UUID> {
    
}
