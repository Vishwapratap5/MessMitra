package com.guru.messmitra.Service.Implementations;

import com.guru.messmitra.DAO.AuthRepo;
import com.guru.messmitra.Model.DTO.ResponseDTO;
import com.guru.messmitra.Model.User;
import com.guru.messmitra.Service.UserAuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    AuthRepo authRepo;

   final private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);

    @Override
    public ResponseDTO RegisterUser(User user) {
        if(authRepo.existsByEmail(user.getEmail())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exists");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        authRepo.save(user);
        return ResponseDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .contactNumber(user.getContactNumber())
                .role(user.getRole())
                .address(user.getAddress())
                .build();
    }

}
