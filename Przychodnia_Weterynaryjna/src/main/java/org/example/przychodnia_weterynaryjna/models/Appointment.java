package org.example.przychodnia_weterynaryjna.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ap_date", nullable = false )
    private LocalDateTime appointmentDate;

    @Size(max = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;


    public Appointment(Animal animal, Client client, Service service, Vet vet, AppointmentStatus status, String description, LocalDateTime appointmentDate) {
        this.animal = animal;
        this.client = client;
        this.service = service;
        this.vet = vet;
        this.status = status;
        this.description = description;
        this.appointmentDate = appointmentDate;
    }

    public Appointment() {

    }


}
