package com.ivchern.exchange_employers.Controllers;

import com.ivchern.exchange_employers.Entity.Request;
import com.ivchern.exchange_employers.Repositories.RequestRepository;
import jdk.jshell.Snippet;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/request", produces = "application/json")
@CrossOrigin("*")
public class RequestController {
    final private RequestRepository requestRepository;

    public RequestController(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    //TODO: ADD recent page
    @GetMapping()
    public Iterable<Request> getRequests(){
        return requestRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Request postRequest(@RequestBody Request request){
        return requestRepository.save(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> postRequest(@PathVariable("id") Long id){
        Optional<Request> optRequest = requestRepository.findById(id);
        if (optRequest.isPresent()){
            return new ResponseEntity<Request>(optRequest.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //TODO: status nocontent or ok
    @PutMapping(path= "/{id}", consumes = "application/json")
    public Request putRequest( @PathVariable("id") Long id,
                               @RequestBody @NotNull Request request) {
        request.setId(id);
        return requestRepository.save(request);
    }

    @DeleteMapping(path= "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteRequest( @PathVariable("id") Long id) {
            try {
                requestRepository.deleteById(id);
            }catch (EmptyResultDataAccessException e) {}; //TODO: add exception
    }
}
