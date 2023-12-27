package com.example.parcel.service;
import com.example.parcel.dto.UserDto;
import com.example.parcel.exception.NotFoundException;
import com.example.parcel.model.User;
import com.example.parcel.repository.UserRepository;
import com.example.parcel.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public List<User> getAll() {
        final List<User> users = this.userRepository.findAll();
        return users;
    }

    /*public UserDto getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return UserMapper.mapToUserDto(user);
        }
        return null; // Or throw an exception as needed / add proper error message

    }

     */
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("user couldn't be found by following id: " + id));
    }

    public List<User> slice(Pageable pageable){
        final List<User> users = new ArrayList<>(this.userRepository.findAll());
        return users;
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    public UserDto updateUser(UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(userDto.getId());
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            //User updatedUser = UserMapper.mapToUser(userDto);
            updateUserFields(existingUser, userDto); // Update fields in existing user object
            userRepository.save(existingUser);
            return userDto;
        }
        return null; // Or throw an exception as needed
        // Implementation to update user
    }
    private void updateUserFields(User existingUser, UserDto userDto) {
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPhoneNumber(userDto.getPhoneNumber());
        existingUser.setAddress(userDto.getAddress());
        // Update other fields as needed
    }




}





/*
    public UserDto registerUser(UserDto userDto) {
        // Register user logic
        User user = UserMapper.mapToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword())); // Encrypt password
        userRepository.save(user);
        return userDto;
    }
    public UserDto loginUser(String email, String password) {
        // Login user logic
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return UserMapper.mapToUserDto(user);
        }
        return null; // Or throw an exception as needed
    }

 */

// Other user-related service methods