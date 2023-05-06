package ru.itis.yaylunch.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.itis.yaylunch.dto.forms.SignInForm;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.repositories.AccountsRepository;
import ru.itis.yaylunch.security.details.AccountUserDetails;
import ru.itis.yaylunch.security.jwt.JwtProvider;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final ObjectMapper objectMapper;
    private final AccountsRepository accountsRepository;
    private final JwtProvider jwtProvider;

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager, ObjectMapper objectMapper, AccountsRepository accountsRepository, JwtProvider jwtProvider) {
        super(authenticationManager);
        this.objectMapper = objectMapper;
        this.accountsRepository = accountsRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            SignInForm signInForm = objectMapper.readValue(request.getReader(), SignInForm.class);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(signInForm.getEmail(), signInForm.getPassword());

            return super.getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        AccountUserDetails accountUserDetails = (AccountUserDetails) authResult.getPrincipal();
        Account account = accountUserDetails.getAccount();
        String token = jwtProvider.createToken(accountUserDetails);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        objectMapper.writeValue(response.getWriter(), Collections.singletonMap("token", token));
    }
}
