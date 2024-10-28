package org.example.przychodnia_weterynaryjna.controllers.DTOs;

import jakarta.validation.constraints.NotBlank;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
