package com.guru.messmitra.Model.DTO;

import com.guru.messmitra.Model.Role;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class ResponseDTO {
    @NotEmpty(message = "Please insert name")
    private String name;

    @Email(message = "Please insert valid email")
    @NotEmpty(message = "Email cannot be empty")
    private String email;


    @NotNull(message = "Please select your role")
    private Role role;

    @NotNull
    @Pattern(regexp="^[0-9]{10}$", message="Enter a valid 10-digit phone number")
    private String contactNumber;


    @NotNull(message = "Please Enter Address")
    private String address;
}
