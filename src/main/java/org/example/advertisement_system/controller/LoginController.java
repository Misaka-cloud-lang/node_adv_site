package org.example.advertisement_system.controller;

import org.example.advertisement_system.entity.ErrorResponse;
import org.example.advertisement_system.entity.AdvHost;
import org.example.advertisement_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        AdvHost advHost = userService.authenticate(request.getUsername(), request.getPassword());
        if (advHost != null) {
            return new ResponseEntity<>(advHost, HttpStatus.OK);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("用户名或密码错误");
            return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
        }
    }

    static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

