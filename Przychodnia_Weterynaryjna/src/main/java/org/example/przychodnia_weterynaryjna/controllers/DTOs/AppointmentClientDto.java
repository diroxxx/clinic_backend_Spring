package org.example.przychodnia_weterynaryjna.controllers.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentClientDto {
    private int id;
    private String vetName;
    private String serviceName;
    private String status;
    private LocalDateTime date;
    private BigDecimal price;
    private String animalName;


    public AppointmentClientDto() {
    }
}
