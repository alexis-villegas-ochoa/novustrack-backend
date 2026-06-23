package io.novustrack.backend.service;

import io.novustrack.backend.model.User;
import io.novustrack.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByEmail (String email){
        return userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found by email: " + email));
    }

    public User createNewUser (String name, String rawPassword, String email){
        if (userRepository.existsUserByEmail(email)){
            throw new RuntimeException("Email is already taken!");
        }
        String hashedPassword = passwordEncoder.encode(rawPassword);

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setPassword(hashedPassword);

        return userRepository.save(newUser);
    }
}
