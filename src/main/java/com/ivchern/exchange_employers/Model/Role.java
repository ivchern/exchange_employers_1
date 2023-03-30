package com.ivchern.exchange_employers.Model;

import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name = "user_roles")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Enumerated(.STRING)
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    List<User> users;
}
