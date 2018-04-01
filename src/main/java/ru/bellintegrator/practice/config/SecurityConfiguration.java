package ru.bellintegrator.practice.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.bellintegrator.practice.registration.service.impl.DigestServiceImpl;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String SOURCE_ENCODING = "UTF-8";
    private static final String HASHING_ALGORITHM = "SHA-256";
    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/registration", "/api/activation/**", "/api/login", "/h2-console/**",
                        "/api/organization/list").permitAll()
                .anyRequest().authenticated().and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder digestService() {
        return new DigestServiceImpl(SOURCE_ENCODING, HASHING_ALGORITHM);
    }

    @Bean
    public ProviderManager createAuthenticationManager() {
        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
        daoProvider.setPasswordEncoder(digestService());
        daoProvider.setUserDetailsService(userDetailsService);
        List<AuthenticationProvider> providers = Collections.singletonList(daoProvider);
        return new ProviderManager(providers);
    }
}
