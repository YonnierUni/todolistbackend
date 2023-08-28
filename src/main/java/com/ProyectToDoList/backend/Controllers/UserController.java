package com.ProyectToDoList.backend.Controllers;

import com.ProyectToDoList.backend.DTO.UserBasicDataDTO;
import com.ProyectToDoList.backend.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/get-user/{id}")
    @ResponseBody
    public UserBasicDataDTO getUserById(@PathVariable Long id){

        return userService.getUserById(id);
    }
}
