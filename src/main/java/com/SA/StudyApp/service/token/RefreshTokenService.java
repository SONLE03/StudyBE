package com.SA.StudyApp.service.token;

import com.SA.StudyApp.model.user.RefreshToken;
import com.SA.StudyApp.repository.user.RefreshTokenRepository;
import com.SA.StudyApp.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    @Value("${security.jwt.refresh_expiration-time}")
    private long jwtRefreshExpiration;
    public RefreshToken generateRefreshToken(UUID userId){
        RefreshToken refreshToken = RefreshToken.builder()
                .user(userRepository.findById(userId).get())
                .token(UUID.randomUUID().toString())
                .expiredDate(new Date(System.currentTimeMillis() + jwtRefreshExpiration))
                .build();
        return refreshTokenRepository.save(refreshToken);
    }
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiredDate().compareTo(Date.from(Instant.now())) < 0) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token was expired. Please make a new signin request");
        }
        return token;
    }
    @Transactional
    public int deleteByUserId(UUID userId) {
        return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }
}