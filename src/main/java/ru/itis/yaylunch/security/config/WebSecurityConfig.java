package ru.itis.yaylunch.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .rememberMe()
                .rememberMeParameter("rememberMe")
                .tokenRepository(tokenRepository())
                .tokenValiditySeconds(60 * 60 * 24 * 365)
                .and()
                .authorizeRequests()
                .antMatchers("/sign-up").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/profile").authenticated()
                .antMatchers("/basket/**").authenticated()
                .antMatchers("/accounts/**").hasAuthority("ADMIN")
                .antMatchers("/order/setStatus/**")
                    .hasAnyAuthority("RESTAURANT", "SCHOOL")
                .antMatchers("/clients").hasAuthority("SCHOOL")
                .antMatchers("/dish/**").hasAuthority("RESTAURANT")
                .antMatchers("/order/account/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/sign-in")
                .defaultSuccessUrl("/")
                .failureUrl("/sign-in?error")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/sign-in?logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);
    }

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}
