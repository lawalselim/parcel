package com.example.parcel.controller;

import com.example.parcel.Messages.SysMessage;
import com.example.parcel.Request.LoginRequest;
import com.example.parcel.Request.UserCreateRequest;
import com.example.parcel.Request.UserDeleteRequest;
import com.example.parcel.model.User;
import com.example.parcel.security.JwtTokenProvider;
import com.example.parcel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.parcel.service.SendEmailService;

import javax.mail.internet.AddressException;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;
    private final SendEmailService sendEmailService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, PasswordEncoder passwordEncoder,SendEmailService sendEmailService) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.sendEmailService = sendEmailService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        User user = userService.getByUserName(loginRequest.getEmail());
        sendEmailService.sendEmails(user.getEmail(), SysMessage.LOGIN_BODY, SysMessage.LOGIN_TOPIC);
        return "Bearer " + jwtToken;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserCreateRequest user) throws AddressException {
        if(userService.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>(SysMessage.EMAIL_ALREADY_IN_USE, HttpStatus.BAD_REQUEST);
        }
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        userService.createUser(newUser);
        sendEmailService.sendEmails(String.valueOf(user.getEmail()), SysMessage.REGISTER_BODY, SysMessage.REGISTER_TOPIC + SysMessage.REGISTER_TOPIC_EMOJI);
        return new ResponseEntity<>(SysMessage.USER_CREATED, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteByUser")
    public ResponseEntity<?> deleteByUser(@RequestBody UserDeleteRequest userDeleteRequest) {
        userService.authDeleteByUser(userDeleteRequest);
        //sendEmailService.sendEmails(userDeleteRequest.getEmail(), SysMessage.AUTH_DELETE_BODY, SysMessage.AUTH_DELETE_TOPIC + SysMessage.AUTH_DELETE_TOPIC_EMOJI);
        return new ResponseEntity<>(SysMessage.USER_DELETED, HttpStatus.OK);
    }

}
