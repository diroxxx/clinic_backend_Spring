package org.example.przychodnia_weterynaryjna.controllers.mapers;

import org.example.przychodnia_weterynaryjna.controllers.DTOs.RegisterDto;
import org.example.przychodnia_weterynaryjna.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {


    public User RegisterDtoMapToUser(RegisterDto registerDto) {
        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setPhoneNumber(registerDto.getPhoneNumber());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        return user;
    }

}
