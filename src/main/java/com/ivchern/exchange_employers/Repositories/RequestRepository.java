package com.ivchern.exchange_employers.Repositories;

import com.ivchern.exchange_employers.Model.Card.RequestWorker;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<RequestWorker, Long> {
}
