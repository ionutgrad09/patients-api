package com.app.patients_api.service;

import com.app.patients_api.exceptions.ForbiddenException;
import com.app.patients_api.model.Role;
import com.app.patients_api.model.entities.User;
import com.app.patients_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public List<User> findAll() {
        return userRepository.findAllNotDeleted();

    }

    public List<User> findAllByUnitId(final long unitId) {
        return userRepository.findAllByUnitIdNotDeleted(unitId);
    }

    public User findByUsername(final String username) {
        return userRepository.findByUsernameNotDeleted(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Transactional
    public User createUser(final User user) {

        if (isEmpty(user.getPassword())) {
            return editUser(user);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(final String username) {
        final var user = findByUsername(username);
        user.setDeleted(true);
        userRepository.save(user);
    }


    private User editUser(final User user) {
        final var userEntity = findByUsername(user.getUsername());

        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setRole(user.getRole());

        if (!userEntity.getUnitId().equals(user.getUnitId()) && !userEntity.getRole().equals(Role.SUPER_ADMIN)) {
            throw new ForbiddenException("You don't have the permission to update the unit");
        }

        userEntity.setUnitId(user.getUnitId());

        return userRepository.save(userEntity);
    }

}
