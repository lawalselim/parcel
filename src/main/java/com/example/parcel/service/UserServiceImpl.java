package com.example.parcel.service;
import com.example.parcel.dto.UserDto;
import com.example.parcel.model.User;
import com.example.parcel.repository.UserRepository;
import com.example.parcel.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.*;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private JWTService jwtService;

    private EncryptionService encryptionService;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JWTService jwtService, EncryptionService encryptionService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.encryptionService =encryptionService;

    }



    public UserDto getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return UserMapper.mapToUserDto(user);
        }
        return null; // Or throw an exception as needed / add proper error message

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

    public UserDto registerUser(UserDto userDto) {
        // Register user logic
        User user = UserMapper.mapToUser(userDto);
        //
        // user.setPassword(passwordEncoder.encode(userDto.getPassword())); // This line of code was testing the internally built encryption service with encoder
        user.setPassword(encryptionService.encryptPassword(userDto.getPassword()));
        userRepository.save(user);
        return userDto;
    }

    public UserDto loginUser(UserDto userDto){
        Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            if (encryptionService.verifyPassword(userDto.getPassword(),user.getPassword())) {
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }

}
