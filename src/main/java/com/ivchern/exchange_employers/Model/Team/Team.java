package com.ivchern.exchange_employers.Model.Team;

import com.ivchern.exchange_employers.Model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Team extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "owner_id")
    private Long ownerId;

}
