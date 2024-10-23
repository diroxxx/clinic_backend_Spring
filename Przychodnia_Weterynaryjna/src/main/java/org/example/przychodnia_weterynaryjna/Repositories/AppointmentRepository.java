package org.example.przychodnia_weterynaryjna.Repositories;

import org.example.przychodnia_weterynaryjna.models.Appointment;
import org.example.przychodnia_weterynaryjna.models.AppointmentStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    @Query("SELECT a FROM Appointment a WHERE a.status IN :statuses and a.client.id = :clientId")
    List<Appointment> getAppointmentsByClient_IdAndByStatus(@Param("statuses") List<AppointmentStatus> statuses, @Param("clientId") int clientId);

}
