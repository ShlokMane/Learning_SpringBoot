package net.javaguides.springboot_restfull_webservices.respository;

import net.javaguides.springboot_restfull_webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
