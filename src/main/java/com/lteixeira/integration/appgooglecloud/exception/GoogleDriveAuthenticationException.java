package com.lteixeira.integration.appgooglecloud.exception;

public class GoogleDriveAuthenticationException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public GoogleDriveAuthenticationException(String message) {
        super(message);
    }
}
