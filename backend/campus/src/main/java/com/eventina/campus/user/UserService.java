package com.eventina.campus.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(exisitng -> {
                throw new IllegalArgumentException("Email already in use" + user.getEmail());
                });
        return userRepository.save(user);

    @Transactional(readOnly = true)
    public User findbyEmail(String email){
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("User with email not found" + email)
        );
    }


    
    }
}
