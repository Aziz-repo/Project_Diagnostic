package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public SecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            .authorizeRequests()
            .antMatchers("/**").permitAll()
            //replaced by @PreAuthorized in ClientRestController
  /*        .antMatchers(HttpMethod.DELETE,"/admin/**").hasAuthority(UserPermission.CLIENT_WRITE.getPermession())
            .antMatchers(HttpMethod.PUT,"/admin/**").hasAuthority(UserPermission.CLIENT_WRITE.getPermession())
            .antMatchers(HttpMethod.POST,"/admin/**").hasAuthority(UserPermission.CLIENT_WRITE.getPermession())
            .antMatchers(HttpMethod.GET,"/admin/**").hasRole(UserRole.ADMIN.name())*/
            .anyRequest()
            .authenticated()
            .and()
            .formLogin();
    }
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                                .username("admin")
                                .password(passwordEncoder.encode("admin"))
                                .roles(UserRole.ADMIN.name())// ROLE_ADMIN
                                .authorities(UserRole.ADMIN.getGrantedAuthorities())//authority aware
                                .build();
        UserDetails client = User.builder()
                                .username("client")
                                .password(passwordEncoder.encode("client"))
                                .roles(UserRole.CLIENT.name())// ROLE_ADMIN
                                .authorities(UserRole.CLIENT.getGrantedAuthorities())//authority aware
                                .build();
            return new InMemoryUserDetailsManager(admin,client);
    }
    
}
