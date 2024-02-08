package com.netdimen.agendaeditor.agenda.controllers;

import com.netdimen.agendaeditor.agenda.controllers.services.AuthService;
import com.netdimen.agendaeditor.agenda.models.Auth.AuthResponse;
import com.netdimen.agendaeditor.agenda.models.Auth.LoginRequest;
import com.netdimen.agendaeditor.agenda.models.Auth.RegisterRequest;
import com.netdimen.agendaeditor.agenda.models.User.Role;
import com.netdimen.agendaeditor.agenda.models.User.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    private ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){

        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping("/signIn")
    private ResponseEntity<AuthResponse> signIn(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.signIn(request));
    }

    @GetMapping("/")
    private String helllo(){
        return "hello";
    }
}
