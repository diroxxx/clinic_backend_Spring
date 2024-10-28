package org.example.przychodnia_weterynaryjna.controllers.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.example.przychodnia_weterynaryjna.models.AppointmentStatus;

import java.time.LocalDateTime;

@Setter
@Getter
public class AppointmentDto {

    private int vetId;
    private int clientId;
    private int serviceId;
    private int animalId;
    private LocalDateTime appointmentDate;
    private String description;
    private AppointmentStatus status;

    public AppointmentDto() {
        this.status = AppointmentStatus.scheduled;
    }

    public AppointmentDto(int vetId, int clientId, int serviceId, int animalId, LocalDateTime appointmentDate, String description) {
        this.vetId = vetId;
        this.clientId = clientId;
        this.serviceId = serviceId;
        this.animalId = animalId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

}
