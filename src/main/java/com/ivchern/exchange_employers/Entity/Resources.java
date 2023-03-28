package com.ivchern.exchange_employers.Entity;

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
//    private StatusCard status;
    private String owner;
    private String text;
    private String description;
//    private DateTimeFormat created;
//    private DateTimeFormat last_updated;
//    private DateTimeFormat end_date;

}

//enum StatusCard{
//    OPEN,
//    CLOSE
//}
