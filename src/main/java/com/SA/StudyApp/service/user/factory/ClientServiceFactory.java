package com.SA.StudyApp.service.user.factory;

import com.SA.StudyApp.dto.request.user.UserRequest;
import com.SA.StudyApp.dto.request.user.UserUpdateRequest;
import com.SA.StudyApp.model.user.Client;
import com.SA.StudyApp.model.user.User;
import com.SA.StudyApp.repository.image.ImageRepository;
import com.SA.StudyApp.repository.user.UserRepository;
import com.SA.StudyApp.service.user.service.UserDetailService;
import com.SA.StudyApp.util.fileUpload.FileUploadImp;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientServiceFactory extends UserServiceFactory{
    public ClientServiceFactory(PasswordEncoder passwordEncoder, ImageRepository imageRepository, UserDetailService userDetailService, UserRepository userRepository, FileUploadImp fileUploadImp) {
        super(passwordEncoder, imageRepository, userDetailService, userRepository, fileUploadImp);
    }
    @Override
    @Transactional
    protected User createUser(User user, UserRequest userRequest) {
        return new Client(user);
    }
    @Override
    @Transactional
    protected User updateUser(User user, UserUpdateRequest userRequest) {
        return user;
    }


    @Override
    protected List<User> getAllUsersByRole(Integer role) { return getAllUsers(role); }
}

