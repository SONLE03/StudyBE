package com.SA.StudyApp.service.authentication;


import com.SA.StudyApp.dto.request.authentication.AuthenticationRequest;
import com.SA.StudyApp.dto.request.authentication.RegisterRequest;
import com.SA.StudyApp.dto.response.authentication.AuthenticationResponse;
import com.SA.StudyApp.dto.response.authentication.CookieResponse;
import com.SA.StudyApp.dto.response.user.UserResponse;
import com.SA.StudyApp.model.user.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseCookie;

import java.util.Optional;

public interface AuthenticationService {
    User signup(RegisterRequest registerRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
    CookieResponse signout();
    Optional<ResponseCookie> refreshToken(HttpServletRequest request);
    UserResponse me();

}
