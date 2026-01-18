package com.eventina.campus.user.dto;

import java.util.Set;

import com.eventina.campus.user.Role;

public class UserResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Set<Role> roles;

    public UserResponse() {

    }
    
    public UserResponse(Long id, String email, String firstName, String lastName, Set<Role> roles) {

        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }
    
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRoles() != null ? user.getRoles() : Set.of());
    }
    

    // ========== Getters ===========

    public Long getId() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public Set<Role> getRoles() {
        return roles;
    }


    // ========== Setters ==========

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
