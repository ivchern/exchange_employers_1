package com.ivchern.exchange_employers.Controllers;

import com.ivchern.exchange_employers.Entity.Resources;
import com.ivchern.exchange_employers.Repositories.ResourcesRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/resources", produces = "application/json")
@CrossOrigin("*")
public class ResourcesController {
    private final ResourcesRepository resourcesRepository;

    public ResourcesController(ResourcesRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }
    //TODO: ADD recent page
    @GetMapping()
    public Iterable<Resources> getResources(){
        return resourcesRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Resources setResources(@RequestBody Resources resources){
        return resourcesRepository.save(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resources> posRequest(@PathVariable("id") Long id){
        Optional<Resources> optResource = resourcesRepository.findById(id);
        if (optResource.isPresent()){
            return new ResponseEntity<Resources>(optResource.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    //TODO: status nocontent or ok
    @PutMapping(path="/{id}", consumes = "application/json")
    public Resources putResource( @PathVariable("id") Long id, @RequestBody Resources resource) {
        resource.setId(id);
        return resourcesRepository.save(resource);
    }

    @DeleteMapping(path= "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResource( @PathVariable("id") Long id) {
        try {
            resourcesRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {}; //TODO: add exception
    }
}
