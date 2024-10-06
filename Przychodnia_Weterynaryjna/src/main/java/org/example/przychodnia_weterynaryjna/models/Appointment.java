package org.example.przychodnia_weterynaryjna.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "appointment_date")
    private Date appointmentDate;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
}
