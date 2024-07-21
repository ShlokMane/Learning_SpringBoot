package net.javaguides.todo_management.repository;

import net.javaguides.todo_management.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
