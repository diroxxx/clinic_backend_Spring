package org.example.przychodnia_weterynaryjna.controllers.mapers;

import org.example.przychodnia_weterynaryjna.controllers.DTOs.VetDto;
import org.example.przychodnia_weterynaryjna.models.Vet;
import org.springframework.stereotype.Service;

@Service
public class VetMapper {

    public VetDto VetMapToVetDto(Vet vet) {
        VetDto vetDto = new VetDto();
        vetDto.setId(vet.getId());
        vetDto.setFirstName(vet.getUser().getFirstName());
        vetDto.setLastName(vet.getUser().getLastName());
        return vetDto;
    }
}
