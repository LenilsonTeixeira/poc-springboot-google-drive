package com.lteixeira.integration.appgooglecloud.configuration;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.json.JsonFactory;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Configuration
public class GoogleDriveCredentialConfig {

    @Bean
    public GoogleClientSecrets googleClientSecrets(final JsonFactory jsonFactory) throws IOException {
        final File credenciais = new File("credentials.json");
        final InputStream in = FileUtils.openInputStream(credenciais);
        return GoogleClientSecrets.load(jsonFactory, new InputStreamReader(in));
    }
}
