package com.SA.StudyApp.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum APIStatus {

    // User
    EMAIL_ALREADY_EXISTED(400, "Email already existed"),
    PHONE_ALREADY_EXISTED(400, "Phone already existed"),
    USER_NOT_FOUND(404, "User not found"),
    CUSTOMER_NOT_FOUND(404, "Customer not found"),
    ADDRESS_NOT_FOUND(404, "Address not found"),
    ROLE_NOT_FOUND(404, "Role not found"),
    CUSTOMER_ADDRESS_NOT_FOUND(404, "Customer and address not found"),
    PASSWORD_INCORRECT(400, "Incorrect password. Please re-enter password!"),
    IMAGE_NOT_FOUND(404, "Image not found"),
    // Email (Send OTP)
    OTP_EXPIRY(400, "OTP has expired!"),
    OTP_INVALID(400, "Invalid OTP!");
    private final int status;
    private final String message;
}
