package org.example.przychodnia_weterynaryjna.services;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.repositories.AppointmentRepository;
import org.example.przychodnia_weterynaryjna.models.Appointment;
import org.example.przychodnia_weterynaryjna.models.AppointmentStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;


    public void makeAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByClientId( List<AppointmentStatus> statuses, int clientId) {
        return appointmentRepository.getAppointmentsByClient_IdAndByStatus(statuses, clientId);
    }


}
