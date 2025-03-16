package com.app.patients_api.repository;

import com.app.patients_api.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.username = :username AND NOT u.deleted")
    Optional<User> findByUsernameNotDeleted(String username);

    @Query("SELECT u FROM User u WHERE u.unitId = :unitId AND NOT u.deleted ORDER BY u.username")
    List<User> findAllByUnitIdNotDeleted(Long unitId);

    @Query("SELECT u FROM User u WHERE NOT u.deleted and u.role != 'SUPER_ADMIN' ORDER BY u.username")
    List<User> findAllNotDeleted();

}
