package jorge.api.login.jorge.login.v1.controller;

import jorge.api.login.jorge.login.v1.model.Usuario;
import jorge.api.login.jorge.login.v1.service.AuthenticationResponse;
import jorge.api.login.jorge.login.v1.service.AuthenticationService;
import jorge.api.login.jorge.login.v1.service.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/v1")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> registrar(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.registrar(request));
    }

}
