package com.ivchern.exchange_employers.Services.Card;

import com.ivchern.exchange_employers.DTO.CardDTO.ResourceOnRequestDTO;
import com.ivchern.exchange_employers.Model.Card.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceService {
    ResourceOnRequestDTO save(Resource resource);
    ResourceOnRequestDTO update(ResourceOnRequestDTO resourceDTO, Long Id);
    List<ResourceOnRequestDTO> findAll();
    Optional<ResourceOnRequestDTO> findById(Long Id);

}
