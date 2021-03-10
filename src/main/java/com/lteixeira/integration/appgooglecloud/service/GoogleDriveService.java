package com.lteixeira.integration.appgooglecloud.service;

import com.google.api.services.drive.model.FileList;

public interface GoogleDriveService {

    FileList getFiles(final String key);

}
