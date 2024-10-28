package org.example.przychodnia_weterynaryjna.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private BigDecimal price;

    @OneToMany(mappedBy = "service")
    private List<Appointment> appointments = new ArrayList<>();


    public Service() {
    }

    public Service(@NotNull String name, @NotNull BigDecimal price) {
        this.name = name;
        this.price = price;
    }

}
