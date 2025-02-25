package com.example.ss3.service;

import com.example.ss3.dto.UserDto;
import com.example.ss3.entity.UserEntity;
import com.example.ss3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCustomServiceImpl implements UserCustomService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserEntity save(UserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity(userDto.getUsername(),
                passwordEncoder.encode(userDto.getPassword()) ,2);
        return userRepo.save(userEntity);
    }
}
