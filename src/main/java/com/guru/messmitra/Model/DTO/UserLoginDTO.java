package com.guru.messmitra.Model.DTO;

import com.guru.messmitra.Model.Role;
import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class UserLoginDTO {


    @Email(message = "Please insert valid email")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 6, max = 12, message = "Password must be 6-12 characters")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$",
            message = "Password must contain at least 1 uppercase, 1 lowercase, 1 digit, and 1 special character"
    )
    private String password;

    @NotNull(message = "Please select your role")
    private Role role;


    @NotNull(message = "Please Enter Address")
    private String address;
}
