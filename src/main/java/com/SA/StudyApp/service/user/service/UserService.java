package com.SA.StudyApp.service.user.service;

import com.SA.StudyApp.dto.request.user.UserRequest;
import com.SA.StudyApp.dto.request.user.UserUpdateRequest;
import com.SA.StudyApp.model.user.Role;
import com.SA.StudyApp.model.user.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAllUsersByRole(Integer role);
    void createUser(UserRequest userRequest, Role role, MultipartFile image) throws IOException;
    void updateUser(UUID userId, UserUpdateRequest userRequest, MultipartFile image) throws IOException;
    void deleteUser(UUID userId);
}
