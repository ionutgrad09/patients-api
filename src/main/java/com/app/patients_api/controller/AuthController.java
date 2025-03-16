package com.app.patients_api.controller;

import com.app.patients_api.model.dto.UserDto;
import com.app.patients_api.model.dto.mapper.UserMapper;
import com.app.patients_api.service.UserService;
import com.app.patients_api.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserDto user) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            var authentication = authenticationManager.authenticate(authenticationToken);

            final var loggedInUser = userService.findByUsername(authentication.getName());

            return jwtTokenUtil.generateToken(authentication.getName(), loggedInUser.getRole().getName(), loggedInUser.getUnitId());
        } catch (AuthenticationException e) {
            return "Invalid credentials";
        }
    }

    @GetMapping("/encrypt")
    public String encrypt(@RequestParam("password") String password) {
        return passwordEncoder.encode(password);
    }


    @GetMapping("/currentUser")
    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            final var username =  authentication.getName();
            return UserMapper.toDto(userService.findByUsername(username));
        }
        return null;
    }


}