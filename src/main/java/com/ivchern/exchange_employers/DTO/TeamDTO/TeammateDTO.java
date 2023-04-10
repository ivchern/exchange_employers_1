package com.ivchern.exchange_employers.DTO.TeamDTO;

import com.ivchern.exchange_employers.Model.Team.Skill;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TeammateDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String jobTitle;
    private Long teamId;
    private Long OwnerId;
    private Set<String> skills;

}
