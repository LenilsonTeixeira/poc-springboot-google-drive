package com.lteixeira.integration.appgooglecloud.service;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.FileList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class GoogleDriveServiceImpl implements GoogleDriveService{

    @Autowired
    private Drive drive;

    @Override
    public FileList getFiles(String key){
        try {
            log.info("Realizando consulta no Google Drive. Key: {}", key);
            return drive.files().list()
                    .setQ("name contains '" + key + "'")
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .execute();
        } catch (final IOException e) {
            log.error("A consulta no Google Drive não retornou nenhum registro.");
            return new FileList();
        }
    }
}
