package ${package}.${artifactpkg}.controller;

import ${package}.${artifactpkg}.domain.dto.${domain}RequestDTO;
import ${package}.${artifactpkg}.domain.dto.${domain}ResponseDTO;
import ${package}.${artifactpkg}.domain.records.${domain}Record;
import ${package}.${artifactpkg}.services.${domain}Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Tag(name = "${domain}", description = "Endpoints for ${domain} operations")
@RestController
@RequestMapping(value = "/${domain}")
public class ${domain}Controller {

    @Autowired
    private ${domain}Service service;

    @Operation(summary = "Create ${domain}", description = "Create a new ${domain}", tags = { "${domain}" })
    @PostMapping
    public ResponseEntity<${domain}ResponseDTO> create(@RequestBody @Valid ${domain}RequestDTO dto) {

        ${domain}Record ${domain}Record = service.create(new ${domain}Record(null, dto.getName()));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(${domain}Record.id())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Find ${domain} by Id", description = "Find ${domain} by id", tags = { "${domain}" })
    @GetMapping("/{id}")
    public ResponseEntity<${domain}ResponseDTO> findById(@PathVariable("id") String id) {
        ${domain}Record ${domain}Record = service.findById(UUID.fromString(id));
        return ResponseEntity.ok().body(${domain}ResponseDTO.builder()
                .id(${domain}Record.id())
                .name(${domain}Record.name())
                .build());
    }

    @Operation(summary = "Update ${domain} by Id", description = "Update ${domain} by id", tags = { "${domain}" })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") String id, @RequestBody ${domain}RequestDTO dto) {
        service.update(new ${domain}Record(UUID.fromString(id), dto.getName()));
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Delete ${domain} by Id", description = "Delete ${domain} by id", tags = { "${domain}" })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "List all ${domain}", description = "List all ${domain} in the database", tags = {"${domain}"})
    @GetMapping()
    public ResponseEntity<List<${domain}ResponseDTO>> listAll() {
        List<${domain}ResponseDTO> categories = service.listAll()
                .stream()
                .map(${domain}ResponseDTO::create)
                .toList();

        return ResponseEntity.ok(categories);
    }

}
