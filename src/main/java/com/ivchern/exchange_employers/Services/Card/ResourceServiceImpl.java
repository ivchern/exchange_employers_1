package com.ivchern.exchange_employers.Services.Card;

import com.ivchern.exchange_employers.DTO.CardDTO.ResourceDtoOnCreate;
import com.ivchern.exchange_employers.DTO.CardDTO.ResourceDtoOnRequest;
import com.ivchern.exchange_employers.Model.Card.Resource;
import com.ivchern.exchange_employers.Model.Status;
import com.ivchern.exchange_employers.Model.Team.Teammate;
import com.ivchern.exchange_employers.Repositories.ResourceRepository;
import com.ivchern.exchange_employers.Repositories.TeammateRepository;
import org.modelmapper.ModelMapper;
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
    public ResourceDtoOnRequest save(ResourceDtoOnCreate resource) {
        ModelMapper modelMapper = new ModelMapper();

        Resource resourceSave = modelMapper.map(resource, Resource.class);
        resourceSave.setStatus(Status.ACTIVE);
        resourceSave.setCreated(LocalDateTime.now());
        resourceSave.setUpdated(LocalDateTime.now());

        Resource resourceUpd = resourceRepository.save(resourceSave);
        return getResourceDTOEntity(resourceUpd);
    }

    @Override
    public ResourceDtoOnRequest update(ResourceDtoOnRequest resourceDTO, Long Id) {
        resourceDTO.setUpdated(LocalDateTime.now());

        ModelMapper modelMapper = new ModelMapper();
        Resource resource = modelMapper.map(resourceDTO, Resource.class);
        resource.setUpdated(LocalDateTime.now());
        Resource resourceUpd = resourceRepository.save(resource);
        return getResourceDTOEntity(resourceUpd);
    }

    @Override
    public List<ResourceDtoOnRequest> findAll() {
        List<ResourceDtoOnRequest> resourceDTO =  new ArrayList<>();

        Iterable<Resource> resource = resourceRepository.findAll();

        resource.forEach(resource1 -> {
            resourceDTO.add(getResourceDTOEntity(resource1));
        });
        return resourceDTO;
    }

    @Override
    public Optional<ResourceDtoOnRequest> findById(Long id) {
        ResourceDtoOnRequest resourceDTO;
        Optional<Resource> resourceOpt = resourceRepository.findById(id);
        if (resourceOpt.isPresent()){
            resourceDTO = getResourceDTOEntity(resourceOpt.get());
            Optional<ResourceDtoOnRequest> res = Optional.of(resourceDTO);
            return res;
        }else{
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Resource> resourceOpt = resourceRepository.findById(id);
        if (resourceOpt.isPresent()){
            Resource resource = resourceOpt.get();
            resource.setStatus(Status.DELETED);
        }
    }

    public ResourceDtoOnRequest getResourceDTOEntity(Resource resource) {
        ModelMapper modelMapper = new ModelMapper();
        ResourceDtoOnRequest resourceDTO = modelMapper.map(resource, ResourceDtoOnRequest.class);

        Optional<Teammate> teammateOpt = teammateRepository.findById(resource.getTeammateId());
        if (teammateOpt.isPresent()) {
            resourceDTO.setJobTitle(teammateOpt.get().getJobTitle());
            resourceDTO.setRank(teammateOpt.get().getRank());
            resourceDTO.setSkills(teammateOpt.get().getSkills());
        }
        return resourceDTO;
    }
}
