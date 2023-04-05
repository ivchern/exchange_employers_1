package com.ivchern.exchange_employers.Model.Team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    private Long id;
    @Column(name = "skill_name")
    private String skill;
    private String description;
}
