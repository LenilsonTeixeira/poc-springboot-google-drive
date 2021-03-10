package com.lteixeira.integration.appgooglecloud.controller;

import com.google.api.services.drive.model.FileList;
import com.lteixeira.integration.appgooglecloud.service.GoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class GoogleDriveController {

    @Autowired
    private GoogleDriveService googleDriveService;

    @GetMapping
    public FileList getFiles(@RequestParam("key") final String key) {
        return this.googleDriveService.getFiles(key);
    }

}
