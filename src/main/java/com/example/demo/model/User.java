package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
public class User {
    public User(){}
    public User(String id, @Size(max = 40) String email, @NotBlank @Size(max = 100) @NotNull String password, @NotNull LoginMethodEnum loginMethodEnum
    ,@NotNull String userRole, @Size(max = 30) String firstName, @Size(max = 30) String lastName, @Size(max = 10) String gender, @Size(max = 20) String birthday) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.loginMethodEnum = loginMethodEnum;
        this.userRole = userRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
    }
    
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull
    @NotBlank
    private String id;

    @Size(max = 40)
    private String email;

    @NotBlank
    @Size(max = 100)
    @NotNull
    private String password;

    //for simplicity a simple string variable, for multiple roles need list
    private String userRole;

    @NotNull
    @Enumerated(EnumType.STRING)
    private LoginMethodEnum loginMethodEnum;

    @Size(max = 30)
    private String firstName;

    @Size(max = 30)
    private String lastName;

    @Size(max = 10)
    private String gender;

    @Size(max = 20)
    private String birthday;
}
