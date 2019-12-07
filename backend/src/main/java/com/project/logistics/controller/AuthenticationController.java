package com.project.logistics.controller;

import com.project.logistics.dto.SafeUser;
import com.project.logistics.dto.security.AuthToken;
import com.project.logistics.entity.UserEntity;
import com.project.logistics.security.TokenProvider;
import com.project.logistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private AuthenticationManager authenticationManager;
    private TokenProvider tokenProvider;
    private UserService userService;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<AuthToken> register(@RequestBody UserEntity loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getLogin(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping (value = "/sign-up", method = RequestMethod.POST)
    public boolean regNewUser(@RequestBody UserEntity user){
        UserEntity userResult = userService.saveUser(user);
        return userResult != null;
    }

    @GetMapping("/user")
    public SafeUser authUser(Principal userInfo){
        return userService.getSafeUserByLogin(userInfo.getName());
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setTokenProvider(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
