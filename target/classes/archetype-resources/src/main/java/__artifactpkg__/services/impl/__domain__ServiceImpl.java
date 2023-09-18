package ${package}.${artifactpkg}.services.impl;

import ${package}.${artifactpkg}.domain.entities.${domain};
import ${package}.${artifactpkg}.domain.records.${domain}Record;
import ${package}.${artifactpkg}.repositories.${domain}Repository;
import ${package}.${artifactpkg}.services.${domain}Service;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ${domain}ServiceImpl implements ${domain}Service {

    @Autowired
    private ${domain}Repository repository;

    @Override
    public ${domain}Record create(${domain}Record recordObject) {
        ${domain} ${domain} = repository.save(new ${domain}(recordObject.name()) );
        return new ${domain}Record(${domain}.getId(), ${domain}.getName());
    }

    @Override
    public ${domain}Record findById(UUID id) {
        ${domain} ${domain} = this.get${domain}ById(id);
        return new ${domain}Record(${domain}.getId(), ${domain}.getName());
    }

    
    @Override
    public void update(${domain}Record recordObject) {
        ${domain} ${domain} = this.get${domain}ById(recordObject.id());
        ${domain}.setName(recordObject.name());
        ${domain}.setModifieldOn(LocalDateTime.now());
        ${domain}.setModifiedBy("99999");
        repository.save(${domain});      
    }
    
    @Override
    public void delete(UUID id) {
        ${domain} ${domain} = this.get${domain}ById(id);
        repository.delete(${domain});

    }
    
    private ${domain} get${domain}ById(UUID id) {
        return repository.findById(id)
                  .orElseThrow(()-> new ObjectNotFoundException("${domain}", id));
    }

    @Override
    public List<${domain}Record> listAll() {
        return repository.findAll()
            .stream()
            .map(entity -> ${domain}Record.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .build())
            .toList();
    }
    
    
}
