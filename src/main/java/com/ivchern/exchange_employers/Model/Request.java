package com.ivchern.exchange_employers.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class Request {
    @Id
    private Long id;
    private String text;
}
