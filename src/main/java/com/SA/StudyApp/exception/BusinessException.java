package com.SA.StudyApp.exception;

import com.SA.StudyApp.constant.APIStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private final APIStatus apiStatus;
}
