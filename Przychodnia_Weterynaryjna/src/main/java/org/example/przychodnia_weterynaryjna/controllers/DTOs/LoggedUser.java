package org.example.przychodnia_weterynaryjna.controllers.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoggedUser {
    private int id;
    private boolean isUserVet;

    public LoggedUser() {
    }

    @Override
    public String toString() {
        return "LoggedUser{" +
                "id=" + id +
                ", isUserVet=" + isUserVet +
                '}';
    }
}
