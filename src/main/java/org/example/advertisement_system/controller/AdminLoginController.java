package org.example.advertisement_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminLoginController {

    @PostMapping("/admin/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        final String ADMIN_PASSWORD = "1234";
        if (ADMIN_PASSWORD.equals(request.getPassword())) {
            return ResponseEntity.ok(new LoginResponse(true, "success"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false, "密码不正确"));
        }
    }

    static class LoginRequest {
        private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    static class LoginResponse {
        private boolean success;
        private String message;

        public LoginResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}
