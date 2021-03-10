package com.lteixeira.integration.appgooglecloud.configuration;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.drive.Drive;
import com.lteixeira.integration.appgooglecloud.exception.GoogleDriveAuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Slf4j
@Configuration
public class GoogleDriveConfig {

    private static final String APPLICATION_NAME = "appDrive";

    @Bean
    public Drive drive(final Credential credential,final JsonFactory jsonFactory ){
        try {
            final NetHttpTransport netHttpTransport = GoogleNetHttpTransport.newTrustedTransport();
            return new Drive.Builder(netHttpTransport, jsonFactory, credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        }catch (final GeneralSecurityException | IOException e) {
            log.error("Erro ao configurar autenticação com Google Drive. ", e);
            throw new GoogleDriveAuthenticationException("Erro ao configurar autenticação com Google Drive.");
        }
    }
}

