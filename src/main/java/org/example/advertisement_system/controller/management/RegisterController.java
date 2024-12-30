package org.example.advertisement_system.controller.management;

import org.example.advertisement_system.entity.AdvHost;
import org.example.advertisement_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AdvHost advHost) {
        if (userService.register(advHost)) {
            return new ResponseEntity<>("注册成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("用户名已经存在", HttpStatus.BAD_REQUEST);
        }
    }
}
