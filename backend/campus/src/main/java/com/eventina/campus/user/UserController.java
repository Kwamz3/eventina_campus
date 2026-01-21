package com.eventina.campus.user;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventina.campus.user.dto.UserResponse;
import com.eventina.campus.user.dto.UserRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setFirstName(userRequest.getfirstName());
        user.setLastName(userRequest.getlastName());
        user.setRoles(userRequest.getRoles());

        User created = userService.createUser(user);
        return new ResponseEntity<>(UserResponse.fromEntity(created),
                HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.findAll().stream()
                .map(UserResponse::fromEntity)
                .toList();
    }
}
