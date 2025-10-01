package com.guru.messmitra.Utils;


import com.guru.messmitra.DAO.UserRepo;
import com.guru.messmitra.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User UserName= userRepo.findByName(username).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found..!"));
        return new UserDetailsImpl(UserName);
    }
}
