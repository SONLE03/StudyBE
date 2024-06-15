package com.SA.StudyApp.repository.user;

import com.SA.StudyApp.model.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
