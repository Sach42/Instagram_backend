package com.sachin.Instagram.backend.Service;

import com.sachin.Instagram.backend.model.Post;
import com.sachin.Instagram.backend.model.User;
import com.sachin.Instagram.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public User updateUser(Long userId, User userDetails) {
        User existingUser = getUser(userId);
        existingUser.setFirstName(userDetails.getFirstName());
        existingUser.setLastName(userDetails.getLastName());
        existingUser.setAge(userDetails.getAge());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setPhoneNumber(userDetails.getPhoneNumber());
        return userRepository.save(existingUser);
    }

    // Other methods for user management

    public List<Post> getUserPosts(Long userId) {
        User user = getUser(userId);
        return user.getPosts();
    }
}
