package com.example.parcel.service;

import com.example.parcel.Request.UserDeleteRequest;
import com.example.parcel.dto.UserViewDto;
import com.example.parcel.exception.NotFoundException;
import com.example.parcel.model.User;
import com.example.parcel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<User> getAll() {
        final List<User> users = this.userRepository.findAll();
        return users;
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("user couldn't be found by following id: " + id));
    }
    @Override
    public User getByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    public List<User> slice(Pageable pageable){
        final List<User> users = this.userRepository.findAll(pageable).stream().collect(Collectors.toList());
        return users;
    }


    @Override
    public void deleteById(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //update user using the username
    @Override
    public void updateByUserName(int userId, String userName) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            user.get().setUserName(userName);
            userRepository.save(user.get());
        }
    }

    @Override
    public List<UserViewDto> getUserViewDto() {
        final List<UserViewDto> users = this.userRepository.findAll().stream().map(UserViewDto::of).collect(Collectors.toList());
        return users;
    }
    @Override
    public User add(User userCreateDto) {
        this.userRepository.save(new User(userCreateDto.getUserName(), userCreateDto.getFirstName(), userCreateDto.getLastName(),
                userCreateDto.getPassword(), userCreateDto.getPhoneNumber(), userCreateDto.getEmail(), userCreateDto.getUserCreateDate(), userCreateDto.isNotificationPermission()));
        return userCreateDto;
    }

    @Override
    public void authDeleteByUser(UserDeleteRequest userDeleteRequest) {
        User user = userRepository.findByEmail(userDeleteRequest.getEmail());
        userRepository.deleteById(user.getId());
    }

    /*

    @Override
    public void updateByNotificationPermission(int userId, boolean permission) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            user.get().setNotificationPermission(permission);
            userRepository.save(user.get());
        }



    }
 */
}









