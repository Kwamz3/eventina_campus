package com.eventina.campus.user;


import java.util.List;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.eventina.campus.user.dto.UserResponse;
import com.eventina.campus.user.dto.UserRequest;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getfirstName());
        user.setLastName(request.getlastName());
        user.setRoles(request.getRoles());

        User created = UserService.createUser(user);
        return new ResponseEntity<>(UserResponse.fromEntity(created),
                HttpStatusCode.CREATED);
    }
    
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.findAll().stream()
        .map(UserResponse:: fromEntity)
                .toList();
    }
}
