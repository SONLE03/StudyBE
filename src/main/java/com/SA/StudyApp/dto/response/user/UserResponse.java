package com.SA.StudyApp.dto.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse{
    @JsonProperty
    private UUID Id;
    @JsonProperty
    private String email;
    @JsonProperty
    private String phone;
    @JsonProperty
    private String fullName;
    @JsonProperty
    private String password;
    @JsonProperty
    private Date dateOfBirth;
    @JsonProperty
    private String role;
    @JsonProperty
    private String image;
    @JsonProperty
    private boolean enable;
}