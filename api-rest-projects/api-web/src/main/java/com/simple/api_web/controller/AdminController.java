package com.simple.api_web.controller;

import com.simple.api_web.auth.User;
import com.simple.api_web.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping(path = "/auth")
@Tag(name = "credito-rapido-admin")
public class AdminController {

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        Optional<User> userOptional = userRepository.findByUsername(loginRequest.username());

        if(userOptional.isEmpty() || !userOptional.get().isLoginCorrect(loginRequest, passwordEncoder)){
            throw new BadCredentialsException("invalid: user or password!");
        }
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("credito-rapido-backend")
                .subject(userOptional.get().getUserId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(3000L))
                .build();
        String jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, 3000L));
    }

    //Admin Usuários
}