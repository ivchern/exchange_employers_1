package com.ivchern.exchange_employers.Model.Team;

import com.ivchern.exchange_employers.Model.BaseEntity;
import com.ivchern.exchange_employers.Model.Card.Rank;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "teammate")
public class Teammate extends BaseEntity {
    private String firstname;
    private String lastname;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "rank")
    private Rank rank;
    @Column(name = "team_id")
    private Long teamId;
    @Column(name = "owner_id")
    private Long ownerId;
    @Column(name = "skills")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teammate_skill",
                    joinColumns = {@JoinColumn(name = "teammate_id")},
                    inverseJoinColumns = {@JoinColumn(name = "skill_id")})
    private List<Skill> skills = new ArrayList<>();
}
