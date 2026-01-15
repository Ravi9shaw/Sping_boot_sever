package com.textbond.targetapp.dto;

import com.textbond.targetapp.model.Role;
import com.textbond.targetapp.validation.ValidRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRegisterRequest {

    @NotBlank(message = "Name cannot be empty")
    private String username;

    @Email(message = "Email is invalid")
    @NotBlank(message = "Email is empty")
    private String email;

    @ValidRole(message = "Invalid role")
    private Role role;

    public UserRegisterRequest() {}

    public UserRegisterRequest(String username, String email, Role role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
}
