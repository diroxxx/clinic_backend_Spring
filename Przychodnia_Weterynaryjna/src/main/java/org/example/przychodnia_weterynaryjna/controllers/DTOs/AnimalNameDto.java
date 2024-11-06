package org.example.przychodnia_weterynaryjna.controllers.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalNameDto {
    private int id;
    private String name;

    public AnimalNameDto() {
    }
}
