package com.ivchern.exchange_employers.Services.Card;

import com.ivchern.exchange_employers.DTO.CardDTO.RequestWorkerDtoOnCreate;
import com.ivchern.exchange_employers.Model.Card.RequestWorker;
import com.ivchern.exchange_employers.Model.Status;
import com.ivchern.exchange_employers.Repositories.RequestWorkerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RequestWorkerServiceImpl implements RequestWorkerService {

    private RequestWorkerRepository requestWorkerRepository;

    public RequestWorkerServiceImpl(RequestWorkerRepository requestWorkerRepository) {
        this.requestWorkerRepository = requestWorkerRepository;
    }

    @Override
    public Iterable<RequestWorker> findAll() {
        return requestWorkerRepository.findAll();
    }

    @Override
    public RequestWorker save(RequestWorkerDtoOnCreate requestDto) {
        ModelMapper modelMapper = new ModelMapper();
        RequestWorker requestWorker = modelMapper.map(requestDto, RequestWorker.class);
        requestWorker.setUpdated(LocalDateTime.now());
        requestWorker.setCreated(LocalDateTime.now());
        requestWorker.setStatus(Status.ACTIVE);
        return requestWorkerRepository.save(requestWorker);
    }

    @Override
    public RequestWorker update(RequestWorker requestWorker) {
        requestWorker.setUpdated(LocalDateTime.now());
        return requestWorkerRepository.save(requestWorker);
    }

    @Override
    public Optional<RequestWorker> findById(Long id) {
        return requestWorkerRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        Optional<RequestWorker> requestWorkerOpt = requestWorkerRepository.findById(id);
        if( requestWorkerOpt.isPresent()){
            RequestWorker requestWorker = requestWorkerOpt.get();
            requestWorker.setUpdated(LocalDateTime.now());
            requestWorker.setStatus(Status.DELETED);
            requestWorkerRepository.save(requestWorker);
        }
    }
}