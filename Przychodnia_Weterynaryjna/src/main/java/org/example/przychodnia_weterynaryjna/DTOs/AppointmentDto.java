package org.example.przychodnia_weterynaryjna.DTOs;

import org.example.przychodnia_weterynaryjna.models.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
