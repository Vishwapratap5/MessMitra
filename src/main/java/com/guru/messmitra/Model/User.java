package com.guru.messmitra.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Entity
@Table(name="UserInfo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotEmpty(message="Please Insert Name")
    private String name;


    @Email(message="Please Insert Valid Email")
    private String email;


    @Size(min = 6 , max = 12 ,message = "Please Enter Valid Password")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$",
            message = "Password must contain at least 1 uppercase, 1 lowercase, 1 digit and 1 special character"
    )
    private String password;


    @NotNull(message = "You Fogot your role Sir / Mam")
    @Enumerated(EnumType.STRING)
    private Role role;


    @Pattern(regexp="^[0-9]{10}$", message="Enter valid 10-digit phone number")
    private String contactNumber;


    @NotNull(message = "Please Enter Address")
    private String address;


    @CreationTimestamp
    @Column(updatable=false, nullable=false)
    private Timestamp createdAt;


    @UpdateTimestamp
   @Column(nullable=false)
    private Timestamp updatedAt;
}
