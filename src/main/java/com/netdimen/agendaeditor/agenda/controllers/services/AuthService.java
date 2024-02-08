package com.netdimen.agendaeditor.agenda.controllers.services;

import com.netdimen.agendaeditor.agenda.models.Auth.AuthResponse;
import com.netdimen.agendaeditor.agenda.models.Auth.LoginRequest;
import com.netdimen.agendaeditor.agenda.models.Auth.RegisterRequest;
import com.netdimen.agendaeditor.agenda.models.User.Role;
import com.netdimen.agendaeditor.agenda.models.User.User;
import com.netdimen.agendaeditor.agenda.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;

    public AuthService(UserRepository userRepository, JWTService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public AuthResponse signIn(RegisterRequest request) {
        User user = new User(request.getName(), request.getEmail(), request.getUsername(), request.getPassword(), Role.USER);
        userRepository.save(user);
        return new AuthResponse(jwtService.getToken(user));
    }

    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
