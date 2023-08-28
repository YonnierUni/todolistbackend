package com.ProyectToDoList.backend.Services;

import com.ProyectToDoList.backend.DTO.UserBasicDataDTO;
import com.ProyectToDoList.backend.Models.UserModel;
import com.ProyectToDoList.backend.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserBasicDataDTO getUserById(Long id){
        UserModel  user = userRepository.findById(id).get();

        UserBasicDataDTO UserBasicDataDTO=new UserBasicDataDTO(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail());

        return UserBasicDataDTO;
    }
}
