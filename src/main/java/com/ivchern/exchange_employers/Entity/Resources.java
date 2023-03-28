package com.ivchern.exchange_employers.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Resources {

    @Id
    private Long id; 
    private String text; 
    
}
