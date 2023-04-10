package com.ivchern.exchange_employers.Controllers.CardControllers;

import com.ivchern.exchange_employers.DTO.CardDTO.ResourceOnRequestDTO;
import com.ivchern.exchange_employers.Model.Card.Resource;
import com.ivchern.exchange_employers.Services.Card.ResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/resources", produces = "application/json")
@CrossOrigin("*")
public class ResourcesController {
    private final ResourceService resourceService;

    public ResourcesController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }


 //TODO: ADD recent page
    @GetMapping()
    public List<ResourceOnRequestDTO> getResources(){
        return resourceService.findAll();
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResourceOnRequestDTO setResources(@RequestBody Resource resource){
        return resourceService.save(resource);
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Resource> posRequest(@PathVariable("id") Long id){
//        Optional<Resource> optResource = resourceRepository.findById(id);
//        if (optResource.isPresent()){
//            return new ResponseEntity<Resource>(optResource.get(), HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
//    @ResponseStatus(HttpStatus.OK)
//    @PutMapping(path="/{id}", consumes = "application/json")
//    public Resource putResource(@PathVariable("id") Long id, @RequestBody Resource resource) {
//        resource.setId(id);
//        return resourceRepository.save(resource);
//    }
//
//    @DeleteMapping(path= "/{id}", consumes = "application/json")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteResource( @PathVariable("id") Long id) {
//        try {
//            resourceRepository.deleteById(id);
//        }catch (EmptyResultDataAccessException e) {};
//    }
}
