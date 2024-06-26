package com.example.ClinicalApp.controller;

import com.example.ClinicalApp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UserController {


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/user")
    @CrossOrigin("*")
    public class UserController {
        @Autowired
        private UserServiceImpl service;

        @PostMapping("/register")
        public HashMap<String, String> userRegistration(@RequestBody UserEntity userEntity){
            return service.userRegistration(userEntity);
        }
        @PostMapping("/login")
        public HashMap<String, String> userLogin(@RequestBody UserLoginDTO userLoginDto){
            return service.userLogin(userLoginDto);
        }

        @GetMapping("/getUserByToken")
        public UserEntity getUser(@RequestHeader String token){
            return service.getUser(token);
        }

        @PutMapping("/changeEmail")
        public HashMap<String, String> changeEmail(@RequestBody UserDetailsChangeDTO userDetailsChangeDTO, @RequestHeader String token)
        {
            return service.changeEmail(userDetailsChangeDTO, token);
        }

        @PutMapping("/changePassword")
        public HashMap<String, String> changePassword(@RequestBody UserPasswordChangeDTO userPasswordChangeDTO, @RequestHeader String token)
        {
            return service.changePassword(userPasswordChangeDTO, token);
        }


        @GetMapping("/getEmail")
        public ResponseEntity<List<String>> getEmail()
        {
            ResponseEntity<List<String>> response = service.getAllEmailId();
            return response;

        }

        @PostMapping("/sendEmail")
        public HashMap<String, String> sendAllEmail(@RequestBody UserEmailDTO userEmailDTO, @RequestHeader String link)
        {

            service.sendEmailToAllUsers(userEmailDTO,link);
            HashMap<String, String> response = new HashMap<>();
            response.put("Status" , "OK");
            return response;
        }


        @GetMapping("/getUser/{id}")
        public Optional<UserEntity> getUserById(@PathVariable Long id){
            return service.getUser(id);
        }




        @GetMapping("/getToken/{emailId}")
        public HashMap<String ,String> getByToken(@PathVariable String emailId) {

            return service.regUserBySSO(emailId);



        }


    }
