package com.example.car_service_schedule.services.Impl;

import com.example.car_service_schedule.models.beans.LoggedUser;
import com.example.car_service_schedule.models.dto.LoginUserInfoDTO;
import com.example.car_service_schedule.models.dto.LoginUsersImportDTO;
import com.example.car_service_schedule.models.dto.UserDTO;
import com.example.car_service_schedule.models.dto.UserRegisterInfoDTO;
import com.example.car_service_schedule.models.entity.softUsers.Roles;
import com.example.car_service_schedule.models.entity.softUsers.Users;
import com.example.car_service_schedule.repositories.UsersRepository;
import com.example.car_service_schedule.services.UserService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, Gson gson, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.usersRepository = usersRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean usersAreImported() {
        return this.usersRepository.count() > 0;
    }

    @Override
    public void fillUsersRepo() throws IOException {

        if (usersAreImported()) {
            return;
        }

        FileReader fileReader = new FileReader(Path.of("src/main/resources/db_data/users.json").toFile());

        List<Users> usersList = Arrays.stream(gson.fromJson(fileReader, LoginUsersImportDTO[].class))
                .map(userImport -> modelMapper.map(userImport, Users.class))
                .collect(Collectors.toList());

        usersRepository.saveAll(usersList);

        fileReader.close();
    }

    @Override
    public void loginUser(LoginUserInfoDTO loginUserInfoDTO) {
        UserDTO mapped = this.modelMapper
                .map(this.usersRepository
                                .findByUsernameAndPassword(loginUserInfoDTO.getUsername(), loginUserInfoDTO.getPassword()),
                        UserDTO.class);

        this.loggedUser.setId(mapped.getId());
        this.loggedUser.setUsername(mapped.getUsername());
        this.loggedUser.setPassword(mapped.getPassword());
        this.loggedUser.setRole(mapped.getRole());
    }

    @Override
    public void registerUser(UserRegisterInfoDTO userRegisterInfoDTO) {
        Users mappedRegisterUser = this.modelMapper.map(userRegisterInfoDTO, Users.class);
        mappedRegisterUser.setRole(Roles.USER);
        this.usersRepository.saveAndFlush(mappedRegisterUser);
    }

}
