package com.ivchern.exchange_employers.Repositories;

import com.ivchern.exchange_employers.Entity.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {
}
