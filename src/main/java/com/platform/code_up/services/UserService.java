package com.platform.code_up.services;

import com.platform.code_up.dtos.UserDto;
import com.platform.code_up.entities.User;
import com.platform.code_up.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    public UserDto getUserbyId(Integer id) {

        User user = userRepository.findById(id).orElseThrow();

        return UserDto.builder().email(user.getEmail())
                .avatar(user.getAvatar()).build();
    }

    public UserDto updateUser(Integer id, UserDto userDto) {

        User user = userRepository.findById(id).orElseThrow();

        user.setEmail(userDto.getEmail());
        user.setAvatar(userDto.getAvatar());

        User updated = userRepository.save(user);

        return new UserDto(
                updated.getEmail(),
                updated.getAvatar(),
                updated.getCreatedAt() != null ? updated.getCreatedAt().toString() : "N/A"
        );

    }

    public void deleteUser(Integer id) {

        if(!userRepository.existsById(id)) {

            throw new UsernameNotFoundException("User does not exist");

        }
        userRepository.deleteById(id);
    }
}