package org.example.przychodnia_weterynaryjna.controllers.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnimalRegisterDto {

    @NotBlank(message = "Please enter the animal's name. If the animal doesn’t have a name, choose one for easy identification")
    private String name;
    private int typeId;
    private int clientId;

    public AnimalRegisterDto(String name, int typeId, int clientId) {
        this.name = name;
        this.typeId = typeId;
        this.clientId = clientId;
    }

    public AnimalRegisterDto() {
    }

    @Override
    public String toString() {
        return "AnimalRegisterDto{" +
                "name='" + name + '\'' +
                ", typeId=" + typeId +
                ", clientId=" + clientId +
                '}';
    }
}
