package ru.bellintegrator.practice.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.registration.view.LoginRequestView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class LoginController {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager am;

    @Autowired
    public LoginController(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, AuthenticationManager am) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.am = am;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public void login(@RequestBody LoginRequestView loginRequestView) {
        UserDetails user = userDetailsService.loadUserByUsername(loginRequestView.login);

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        List<AuthenticationProvider> providers = new ArrayList<>();
        providers.add(daoAuthenticationProvider);
        AuthenticationManager authenticationManager = new ProviderManager(providers);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestView.login, loginRequestView.password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        authentication.getDetails();

    }
}
