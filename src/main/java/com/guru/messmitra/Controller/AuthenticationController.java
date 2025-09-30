package com.guru.messmitra.Controller;

import com.guru.messmitra.Model.DTO.ResponseDTO;
import com.guru.messmitra.Model.User;
import com.guru.messmitra.Service.UserAuthService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthenticationController {

    UserAuthService userAuthService;

    @GetMapping("/getcsrf")
    public CsrfToken getCsrf(HttpServletRequest req) throws Exception {
        return (CsrfToken) req.getAttribute("_csrf");
    }
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody User user) {
        ResponseDTO signupDTO=userAuthService.RegisterUser(user);
        return ResponseEntity.ok(signupDTO);
    }
}
