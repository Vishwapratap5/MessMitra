package com.guru.messmitra.Service;

import com.guru.messmitra.Model.DTO.ResponseDTO;
import com.guru.messmitra.Model.User;

public interface UserAuthService {
    ResponseDTO RegisterUser(User user);
}
