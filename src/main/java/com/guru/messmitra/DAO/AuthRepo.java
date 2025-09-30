package com.guru.messmitra.DAO;

import com.guru.messmitra.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<User, Integer> {
    Boolean existsByEmail(String email);
}
