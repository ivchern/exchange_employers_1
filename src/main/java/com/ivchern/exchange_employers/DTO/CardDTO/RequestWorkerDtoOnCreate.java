package com.ivchern.exchange_employers.DTO.CardDTO;

import com.ivchern.exchange_employers.Model.Card.Rank;
import com.ivchern.exchange_employers.Model.Team.Skill;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class RequestWorkerDtoOnCreate {
    private String jobTitle;
    private String projectName;
    private Rank rank;
    private String description;
    private String locationWorked;
    private Date needBefore;
    private boolean isInterviewNeeded;
    private List<Skill> skills;
}
