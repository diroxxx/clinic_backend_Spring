package org.example.przychodnia_weterynaryjna.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email
    @Column(unique = true)
    @Size(min = 2, max = 50)
    private String email;

    @Size(min = 9, max = 9)
    private String phoneNumber;


    @NotNull
    @Size(min = 8, max = 40)
    private String password;

    @NotNull

    @Enumerated(EnumType.STRING)
    private UserRole role;



    public User() {
    }

    public User(String firstName, String lastName, String email, String phoneNumber, String password, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @Size(min = 1, max = 50) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull @Size(min = 1, max = 50) String firstName) {
        this.firstName = firstName;
    }

    public @NotNull @Size(min = 1, max = 50) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @Size(min = 1, max = 50) String lastName) {
        this.lastName = lastName;
    }

    public @NotNull @Email @Size(min = 2, max = 50) String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email @Size(min = 2, max = 50) String email) {
        this.email = email;
    }

    public @Size(min = 9, max = 9) String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Size(min = 9, max = 9) String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotNull @Size(min = 8, max = 40) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 8, max = 40) String password) {
        this.password = password;
    }

    public @NotNull Enum<UserRole> getRole() {
        return role;
    }

    public void setRole(@NotNull UserRole role) {
        this.role = role;
    }
}
