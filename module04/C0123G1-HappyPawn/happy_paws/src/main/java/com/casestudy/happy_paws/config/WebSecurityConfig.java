package com.casestudy.happy_paws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//Sử dụng thuật toán Bcrypt để mã hóa password.
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //Khi tạo mới tài khoản thì cần mã hóa mật khẩu trước khi lưu vào DB
//        String password = bCryptPasswordEncoder.encode("123123");
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests().antMatchers("/happy_paws/assets/css/**", "/happy_paws/assets/js/**", "/images/**","/happy-paws-home", "/static/**").permitAll();


        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/account/login","/customer/create","/customer/save","/customer/get-code","/customer/check","/").permitAll();

//        http.authorizeRequests()
//                .antMatchers("/customer")
//                .access("hasAnyRole('CUSTOMER', 'ADMIN')");

        http.authorizeRequests()
                .antMatchers("*", "/customer/*", "/employee","search-employee","/create-employee","/update-employee/**")
                .access("hasRole('ADMIN')");
        http.authorizeRequests()
                .antMatchers( "/delete-product","/detail/*","/order-detail/payment-cart/*","/booking/**","/add-cart","/cart")
                .access("hasRole('CUSTOMER')");
        http.authorizeRequests()
                .antMatchers("/account", "/account/**","/detail/*")
                .access("hasAnyRole('CUSTOMER','ADMIN')");
        http.authorizeRequests()
                .antMatchers("/orders*", "/orders/**","order-detail/*","/order-detail/**")
                .access("hasAnyRole('ADMIN')");
        http.authorizeRequests()
                .antMatchers("/api/admin/product", "/api/admin/product-type","/api/admin/product-type/*","/api/admin/product/*")
                .access("hasAnyRole('ADMIN')");

        http.authorizeRequests()
                .antMatchers("/api/admin/service", "/api/admin/service/**", "/api/admin/pet-service/**", "/api/admin/booking-service/*")
                .access("hasAnyRole('ADMIN')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/customers/403");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/account/security") // Submit URL
                .loginPage("/account/login")//
                .defaultSuccessUrl("/")//
                .failureUrl("/account/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/account/logout").logoutSuccessUrl("/account/logoutSuccessful");

        // Cấu hình Remember Me.
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }

}