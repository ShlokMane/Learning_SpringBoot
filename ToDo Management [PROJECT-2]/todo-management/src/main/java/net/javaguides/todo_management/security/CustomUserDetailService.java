package net.javaguides.todo_management.security;

import lombok.AllArgsConstructor;
import net.javaguides.todo_management.entity.User;
import net.javaguides.todo_management.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
                () -> new UsernameNotFoundException("User not exists by username or email.")
        );

        Set<GrantedAuthority> authoritySet = user.getRoles().stream().map(
                (role) -> new SimpleGrantedAuthority((role.getName()))
        ).collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(usernameOrEmail, user.getPassword(), authoritySet);
    }
}
