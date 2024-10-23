package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.Repositories.AppointmentRepository;
import org.example.przychodnia_weterynaryjna.models.Appointment;
import org.example.przychodnia_weterynaryjna.models.AppointmentStatus;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void makeAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByClientId( List<AppointmentStatus> statuses, int clientId) {
        return appointmentRepository.getAppointmentsByClient_IdAndByStatus(statuses, clientId);
    }


}
