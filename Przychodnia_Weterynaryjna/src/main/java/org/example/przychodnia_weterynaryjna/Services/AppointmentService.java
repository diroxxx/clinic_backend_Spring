package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.Repositories.AppointmentRepository;
import org.example.przychodnia_weterynaryjna.models.Appointment;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void makeAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
