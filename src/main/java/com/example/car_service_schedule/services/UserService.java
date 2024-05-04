package com.example.car_service_schedule.services;

import com.example.car_service_schedule.models.dto.LoginUserInfoDTO;
import com.example.car_service_schedule.models.dto.UserRegisterInfoDTO;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserService {
    boolean usersAreImported();

    void fillUsersRepo() throws FileNotFoundException, IOException;

    void loginUser(LoginUserInfoDTO loginUserInfoDTO);

    void registerUser(UserRegisterInfoDTO userRegisterInfoDTO);
}
