package com.SA.StudyApp.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("admin"),
    CLIENT("client");
    private final String role;
    public static Role convertIntegerToRole(int role) {
        return switch (role) {
            case 0 -> Role.ADMIN;
            case 1 -> Role.CLIENT;
            default -> null;
        };
    }
}
