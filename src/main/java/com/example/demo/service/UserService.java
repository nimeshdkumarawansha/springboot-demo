package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO getUserById(int user_id) {
        User user = userRepo.getUserById(user_id);
        return modelMapper.map(user, UserDTO.class);
    }
    public UserDTO saveUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepo.save(user);
        return userDTO;
    }
    public UserDTO updateUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepo.save(user);
        return userDTO;
    }
    public String deleteUser(UserDTO userDTO) {;
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return "User deleted";
    }
    public String deleteUserById(int user_id) {
        userRepo.deleteById(user_id);
        return "User deleted";
    }
}
