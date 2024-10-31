package org.example.przychodnia_weterynaryjna.controllers.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ServiceDto {
    private String name;
    private BigDecimal price;
}


