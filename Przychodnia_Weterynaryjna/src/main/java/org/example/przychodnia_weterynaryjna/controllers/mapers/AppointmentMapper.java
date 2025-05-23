package org.example.przychodnia_weterynaryjna.controllers.mapers;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.AppointmentClientDto;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.AppointmentDto;
import org.example.przychodnia_weterynaryjna.models.Appointment;
import org.example.przychodnia_weterynaryjna.services.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentMapper {
    private final ClientService clientService;
    private final AnimalService animalService;
    private final VetService vetService;
    private final ServiceTypeService serviceTypeService;


    public Appointment appointmentDtoToAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setDescription(appointmentDto.getDescription());
        appointment.setStatus(appointmentDto.getStatus());
        appointment.setClient(clientService.getClientById(appointmentDto.getClientId()).orElseThrow());
        appointment.setVet(vetService.getVetById(appointmentDto.getVetId()).orElseThrow());
        appointment.setAnimal(animalService.getAnimalById(appointmentDto.getAnimalId()).orElseThrow());
        appointment.setService(serviceTypeService.getServiceById(appointmentDto.getServiceId()).orElseThrow());
        return appointment;
    }
    public AppointmentClientDto AppointmentToAppointmentClientDto(Appointment appointment) {
        AppointmentClientDto appointmentClientDto = new AppointmentClientDto();
        appointmentClientDto.setId(appointment.getId());
        appointmentClientDto.setDate(appointment.getAppointmentDate());
        appointmentClientDto.setPrice(appointment.getService().getPrice());
        appointmentClientDto.setAnimalName(appointment.getAnimal().getName());
        appointmentClientDto.setServiceName(appointment.getService().getName());
        appointmentClientDto.setVetName(appointment.getVet().getUser().getFirstName() + " " + appointment.getVet().getUser().getLastName());
        appointmentClientDto.setStatus(appointment.getStatus().name());
        return appointmentClientDto;
    }
}
