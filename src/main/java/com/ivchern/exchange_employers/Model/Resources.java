package com.ivchern.exchange_employers.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
public class Resources {

    @Id
    private Long id;
    private String owner;
    private String text;
    private String description;

}

