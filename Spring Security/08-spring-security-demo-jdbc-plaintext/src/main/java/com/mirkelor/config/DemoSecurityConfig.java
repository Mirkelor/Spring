package com.mirkelor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    // add a reference to our security data source

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // use jdbc authentication ... oh yeah

        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .anyRequest().authenticated()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/showMyLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                .and()
                    .logout().permitAll()
                .and()
                    .exceptionHandling().accessDeniedPage("/access-denied");

    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
