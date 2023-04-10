package com.ivchern.exchange_employers.Services.Teammate;

import com.ivchern.exchange_employers.DTO.TeamDTO.TeammateDTO;
import com.ivchern.exchange_employers.Model.Status;
import com.ivchern.exchange_employers.Model.Team.Teammate;
import com.ivchern.exchange_employers.Repositories.SkillRepository;
import com.ivchern.exchange_employers.Repositories.TeammateRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeammateServiceImpl implements TeammateService{

    private TeammateRepository teammateRepository;
    private SkillRepository skillRepository;

    public TeammateServiceImpl(TeammateRepository teammateRepository, SkillRepository skillRepository) {
        this.teammateRepository = teammateRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public Optional<Teammate> findById(Long id) {
        return teammateRepository.findById(id);
    }

    @Override
    public Iterable<Teammate> findBySkills(List<String> skills) {
        return teammateRepository.findByNameSkills(skills);
    }

    @Override
    public Iterable<Teammate> findAll() {
        return teammateRepository.findAll();
    }

    @Override
    public Teammate save(TeammateDTO teammateDTO) {
        ModelMapper modelMapper = new ModelMapper();

        Teammate teammate = modelMapper.map(teammateDTO, Teammate.class);
        teammate.setCreated(LocalDateTime.now());
        teammate.setUpdated(LocalDateTime.now());
        teammate.setStatus(Status.ACTIVE);
        teammate.setSkills(skillRepository.findByNames(teammateDTO.getSkills()));
        return teammateRepository.save(teammate);
    }

    @Override
    public Teammate update(Teammate teammate, Long id) {
        if(teammateRepository.existsById(teammate.getId())) {
            teammate.setUpdated(LocalDateTime.now());
            return teammateRepository.save(teammate);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        teammateRepository.deleteById(id);;
    }
}
