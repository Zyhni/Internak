package com.id_co_kelompok7.rest;

import com.id_co_kelompok7.model.User;
import com.id_co_kelompok7.respone.DtoResponse;
import com.id_co_kelompok7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserRest {

    @Autowired
    private UserService userService;

    public UserRest(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUserByEmailAndPassword")
    public DtoResponse getSkemas(@RequestParam("email") String email, @RequestParam("password") String password){
        return userService.getUserByEmailAndPassword(email, password);
    }

    @PostMapping("/registerUser")
    public DtoResponse registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/resetPasswordByEmail")
    public DtoResponse resetPasswordByEmail(@RequestParam("email") String email){
        return userService.resetPasswordByEmail(email);
    }

    @PostMapping("/resetPassword")
    public DtoResponse resetPasswordById(@RequestParam("oldpassword") String oldPassword, @RequestParam("newpassword") String newPassword){
        return userService.resetPasswordByTempPassword(oldPassword, newPassword);
    }
}
