package com.lteixeira.integration.appgooglecloud.configuration;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.DriveScopes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Configuration
public class GoogleDriveAuthorizarionConfig {

    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    @Bean
    public Credential authorizationCodeInstalledApp(final JsonFactory jsonFactory, final GoogleClientSecrets googleClientSecrets, final NetHttpTransport netHttpTransport) throws IOException {
        final GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                netHttpTransport, jsonFactory, googleClientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        final LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver)
                .authorize("user");
    }
}
