package com.skkgroup.shoes.auth;


import com.skkgroup.shoes.auth.dto.LoginResponse;
import com.skkgroup.shoes.auth.dto.Loginrequest;
import com.skkgroup.shoes.auth.dto.RegisterRequest;
import com.skkgroup.shoes.auth.user.Role;
import com.skkgroup.shoes.auth.user.UserRepository;
import com.skkgroup.shoes.auth.utility.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.skkgroup.shoes.auth.user.User;

@Service
public class AuthService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    User findUser(String username){
       return userRepository.findByUsername(username).orElseThrow();
    }
    public LoginResponse Register(RegisterRequest registerRequest){
        System.out.println(registerRequest);
        var user = User.builder().username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER).build();
        var userrespons = userRepository.save(user);
        var token= jwtService.generateToken(userrespons);


        return LoginResponse.builder().username(userrespons.getUsername())
                .Token(token).build();


    }


    public LoginResponse  Login(Loginrequest loginrequest){
        System.out.println(loginrequest);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(

                        loginrequest.getUsername(),
                        loginrequest.getPassword()
                )
        );

        var userespons= userRepository.findByUsername(loginrequest.getUsername()).orElseThrow();

        var token= jwtService.generateToken(userespons);


        return LoginResponse.builder().username(userespons.getUsername())
                .Token(token).build();


    }

}
