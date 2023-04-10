package com.ivchern.exchange_employers.DTO.CardDTO;

import com.ivchern.exchange_employers.DTO.TeamDTO.TeammateCardDTO;
import com.ivchern.exchange_employers.Model.Card.Rank;
import com.ivchern.exchange_employers.Model.Status;
import com.ivchern.exchange_employers.Model.Team.Skill;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ResourceOnRequestDTO extends TeammateCardDTO {
    @Id
    private Long id;
    private String jobTitle;
    private Rank rank;

    private String description;
    private String locationWorked;
    private Date fromFree;
    private Date endFree;
    private List<Skill> skills;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Status status;
}