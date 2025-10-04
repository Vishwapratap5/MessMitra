package com.guru.messmitra.Controller;

import com.guru.messmitra.Model.DTO.ResponseDTO;
import com.guru.messmitra.Model.User;
import com.guru.messmitra.Service.UserAuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthenticationController {

    UserAuthService userAuthService;
    AuthenticationManager authenticationManager;
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody User user) {
        ResponseDTO signupDTO=userAuthService.RegisterUser(user);
        return ResponseEntity.ok(signupDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return new ResponseEntity<>("success", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("fail", HttpStatus.UNAUTHORIZED);
        }
    }
}
