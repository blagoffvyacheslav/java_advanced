package com.dmdev.service.service;


import com.dmdev.common.repository.UserRepository;
import com.dmdev.common.models.User;


public class UserService {

    public User getUser(Long id){
        return UserRepository.getUser(id);
    }
}
