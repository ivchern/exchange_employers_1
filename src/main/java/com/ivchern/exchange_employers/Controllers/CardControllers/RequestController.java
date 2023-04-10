package com.ivchern.exchange_employers.Controllers.CardControllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/request", produces = "application/json")
@CrossOrigin("*")
public class RequestController {
//    final private RequestRepository requestRepository;
//
//    public RequestController(RequestRepository requestRepository) {
//        this.requestRepository = requestRepository;
//    }
//
//    //TODO: ADD recent page
//    @GetMapping()
//    public Iterable<RequestWorker> getRequests(){
//        return requestRepository.findAll();
//    }
//
//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public RequestWorker postRequest(@RequestBody RequestWorker request){
//        return requestRepository.save(request);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RequestWorker> postRequest(@PathVariable("id") Long id){
//        Optional<RequestWorker> optRequest = requestRepository.findById(id);
//        if (optRequest.isPresent()){
//            return new ResponseEntity<RequestWorker>(optRequest.get(), HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    //TODO: status nocontent or ok
//    @PutMapping(path= "/{id}", consumes = "application/json")
//    public RequestWorker putRequest( @PathVariable("id") Long id,
//                               @RequestBody @NotNull RequestWorker request) {
//        request.setId(id);
//        return requestRepository.save(request);
//    }
//
//    @DeleteMapping(path= "/{id}", consumes = "application/json")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//        public void deleteRequest( @PathVariable("id") Long id) {
//            try {
//                requestRepository.deleteById(id);
//            }catch (EmptyResultDataAccessException e) {}; //TODO: add exception
//    }
}
