package com.simple.api_web.infra;

import com.simple.api_web.auth.User;
import com.simple.api_web.auth.Role;
import com.simple.api_web.repository.UserRepository;
import com.simple.api_web.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Configuration
public class InitialAdminUserConfiguration implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Role roleAdmin = new Role();
        roleAdmin.setName("admin");
        roleAdmin.setRoleId(1L);
        roleRepository.save(roleAdmin);

        //var role = roleRepository.findByName(Role.Values.ADMIN.name());

        var user = new User();
        user.setUserId(UUID.randomUUID());
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin123"));
        user.setRoles(Set.of(roleAdmin));
        userRepository.save(user);

        //var admin = userRepository.findByUsername("admin");
    }
}