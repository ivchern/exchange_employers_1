package com.ivchern.exchange_employers.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Request {
    @Id
    private Long id;
    private String text;
}
