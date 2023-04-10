package com.ivchern.exchange_employers.Services.Card;

import com.ivchern.exchange_employers.DTO.CardDTO.ResourceOnRequestDTO;
import com.ivchern.exchange_employers.Model.Card.Resource;
import com.ivchern.exchange_employers.Model.Status;
import com.ivchern.exchange_employers.Model.Team.Teammate;
import com.ivchern.exchange_employers.Repositories.ResourceRepository;
import com.ivchern.exchange_employers.Repositories.TeammateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    private TeammateRepository teammateRepository;
    private ResourceRepository resourceRepository;

    public ResourceServiceImpl(TeammateRepository teammateRepository, ResourceRepository resourceRepository) {
        this.teammateRepository = teammateRepository;
        this.resourceRepository = resourceRepository;
    }
    @Override
    public ResourceOnRequestDTO save(Resource resource) {
        resourceRepository.save(resource);

        ResourceOnRequestDTO resourceDTO = getResourceDTOEntity(resource);
        resourceDTO.setCreated(LocalDateTime.now());
        resourceDTO.setUpdated(LocalDateTime.now());
        resourceDTO.setStatus(Status.ACTIVE);

        return resourceDTO;
    }

    @Override
    public ResourceOnRequestDTO update(ResourceOnRequestDTO resourceDTO, Long Id) {
        resourceDTO.setUpdated(LocalDateTime.now());

        ModelMapper modelMapper = new ModelMapper();
        Resource resource = modelMapper.map(resourceDTO, Resource.class);
        resourceRepository.save(resource);

        return resourceDTO;
    }

    @Override
    public List<ResourceOnRequestDTO> findAll() {
        List<ResourceOnRequestDTO> resourceDTO =  new ArrayList<>();

        Iterable<Resource> resource = resourceRepository.findAll();

        resource.forEach(resource1 -> {
            resourceDTO.add(getResourceDTOEntity(resource1));
        });
        return resourceDTO;
    }

    @Override
    public Optional<ResourceOnRequestDTO> findById(Long id) {
        ResourceOnRequestDTO resourceDTO;
        Optional<Resource> resourceOpt = resourceRepository.findById(id);
        if (resourceOpt.isPresent()){
            resourceDTO = getResourceDTOEntity(resourceOpt.get());
            Optional<ResourceOnRequestDTO> res = Optional.of(resourceDTO);
            return res;
        }else{
            return Optional.empty();
        }
    }

    public ResourceOnRequestDTO getResourceDTOEntity(Resource resource) {
        ModelMapper modelMapper = new ModelMapper();
        ResourceOnRequestDTO resourceDTO = modelMapper.map(resource, ResourceOnRequestDTO.class);

        Optional<Teammate> teammateOpt = teammateRepository.findById(resource.getTeammateId());
        if (teammateOpt.isPresent()) {
            resourceDTO.setJobTitle(teammateOpt.get().getJobTitle());
            resourceDTO.setRank(teammateOpt.get().getRank());
            resourceDTO.setSkills(teammateOpt.get().getSkills());
        }
        return resourceDTO;
    }
}
