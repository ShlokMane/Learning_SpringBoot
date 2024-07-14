package net.javaguides.springboot_restfull_webservices.respository;

import net.javaguides.springboot_restfull_webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
