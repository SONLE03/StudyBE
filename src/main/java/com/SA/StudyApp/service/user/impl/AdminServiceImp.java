package com.SA.StudyApp.service.user.impl;


import com.SA.StudyApp.constant.APIStatus;
import com.SA.StudyApp.dto.request.user.UserRequest;
import com.SA.StudyApp.dto.request.user.UserUpdateRequest;
import com.SA.StudyApp.exception.BusinessException;
import com.SA.StudyApp.model.user.Role;
import com.SA.StudyApp.model.user.User;
import com.SA.StudyApp.repository.user.UserRepository;
import com.SA.StudyApp.service.user.factory.AdminServiceFactory;
import com.SA.StudyApp.service.user.service.AdminService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminServiceImp implements AdminService {
    private final AdminServiceFactory adminServiceFactory;
    private final UserRepository userRepository;


    @Override
    public List<User> getAllUsersByRole(Integer role){
        return adminServiceFactory.getAllUsers(role);
    }
    @Override
    @Transactional
    public void createUser(UserRequest userRequest, Role role, MultipartFile image) throws IOException {
        userRepository.save(adminServiceFactory.create(userRequest, role, image));
    }

    @Override
    @Transactional
    public void updateUser(UUID userId, UserUpdateRequest userRequest, MultipartFile image) throws IOException {
        userRepository.save(adminServiceFactory.update(userId, userRequest, image));
    }

    @Override
    @Transactional
    public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new BusinessException(APIStatus.USER_NOT_FOUND));
        userRepository.delete(user);
    }

}
