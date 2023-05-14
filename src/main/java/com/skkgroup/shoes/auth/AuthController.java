package com.skkgroup.shoes.auth;

import com.skkgroup.shoes.auth.dto.LoginResponse;
import com.skkgroup.shoes.auth.dto.Loginrequest;
import com.skkgroup.shoes.auth.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin

public class AuthController {
    @Autowired
    public AuthService authservice;
    @PostMapping("/login")

    public LoginResponse Login(@RequestBody Loginrequest loginrequest){

        return authservice.Login(loginrequest);
    }

    @PostMapping("/register")
    public LoginResponse Registerr (@RequestBody RegisterRequest registerRequest){

        return authservice.Register(registerRequest);

    }
}
