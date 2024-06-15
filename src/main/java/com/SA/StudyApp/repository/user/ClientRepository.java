package com.SA.StudyApp.repository.user;

import com.SA.StudyApp.model.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
