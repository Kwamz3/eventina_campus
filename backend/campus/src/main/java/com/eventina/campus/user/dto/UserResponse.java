package com.eventina.campus.user.dto;

import com.eventina.campus.user.Role;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Set<Role> roles;
    
    public static UserResponse fromEntity(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .roles(user.getRoles() != null ? user.getRoles() : Set.of())
                .build();
    }
    

    // // ========== Getters ===========

    // public Long getId() {
    //     return id;
    // }
    
    // public String getEmail() {
    //     return email;
    // }
    
    // public String getFirstName() {
    //     return firstName;
    // }
    
    // public String getLastName() {
    //     return lastName;
    // }
    
    // public Set<Role> getRoles() {
    //     return roles;
    // }


    // // ========== Setters ==========

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public void setFirstName(String firstName) {
    //     this.firstName = firstName;
    // }

    // public void setLastName(String lastName) {
    //     this.lastName = lastName;
    // }

    // public void setRoles(Set<Role> roles) {
    //     this.roles = roles;
    // }
}
