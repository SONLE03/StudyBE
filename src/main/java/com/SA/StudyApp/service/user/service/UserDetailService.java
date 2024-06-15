package com.SA.StudyApp.service.user.service;
import com.SA.StudyApp.dto.request.user.ChangePasswordRequest;
import com.SA.StudyApp.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;
public interface UserDetailService {
    UserDetails userDetails();

    UUID getIdLogin();
    String getUserFullNameLogin();
    String getUsernameLogin();

    Integer getRoleLogin();
    Integer getRoleById(UUID userId);
    User getProfile(UUID userId);
    String verifyOtp(Integer otp, String email);
    String changePassword(ChangePasswordRequest changePasswordRequest, String email);
}
