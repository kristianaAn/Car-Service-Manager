package com.example.car_service_schedule.services.Impl;

import com.example.car_service_schedule.models.dto.LoginUsersImportDTO;
import com.example.car_service_schedule.models.entity.Users;
import com.example.car_service_schedule.repositories.UsersRepository;
import com.example.car_service_schedule.services.UserService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
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

    public UserServiceImpl(UsersRepository usersRepository, Gson gson) {
        this.usersRepository = usersRepository;
        this.gson = gson;
    }

    @Override
    public boolean usersAreImported() {
        return this.usersRepository.count() > 0;
    }

    @Override
    public void fillUsersRepo() throws IOException {

        if (this.usersRepository.count() > 0) {
            return;
        }

        ModelMapper modelMapper = new ModelMapper();
        FileReader fileReader = new FileReader(Path.of("src/main/resources/db_data/users.json").toFile());

        List<Users> usersList = Arrays.stream(gson.fromJson(fileReader, LoginUsersImportDTO[].class))
                .map(userImport -> modelMapper.map(userImport, Users.class))
                .collect(Collectors.toList());

        usersRepository.saveAll(usersList);

        fileReader.close();
    }

}
