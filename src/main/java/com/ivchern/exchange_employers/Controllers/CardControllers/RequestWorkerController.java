package com.ivchern.exchange_employers.Controllers.CardControllers;

import com.ivchern.exchange_employers.DTO.CardDTO.RequestWorkerDtoOnCreate;
import com.ivchern.exchange_employers.Model.Card.RequestWorker;
import com.ivchern.exchange_employers.Services.Card.RequestWorkerService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/request", produces = "application/json")
@CrossOrigin("*")
public class RequestWorkerController {
    private RequestWorkerService requestWorkerService;

    public RequestWorkerController(RequestWorkerService requestWorkerService) {
        this.requestWorkerService = requestWorkerService;
    }

    @GetMapping()
    public Iterable<RequestWorker> getRequests() {
        return requestWorkerService.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public RequestWorker postRequest(@RequestBody RequestWorkerDtoOnCreate request) {
        return requestWorkerService.save(request);
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    public RequestWorker putRequest(@PathVariable("id") Long id,
                                    @RequestBody @NotNull RequestWorker request) {
        return requestWorkerService.update(request);
    }

    @DeleteMapping(path = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRequest(@PathVariable("id") Long id) {
         requestWorkerService.delete(id);
    }
}
