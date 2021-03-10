package com.lteixeira.integration.appgooglecloud.listener;

import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpDownloaderProgressListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileDownloadProgressListener implements MediaHttpDownloaderProgressListener {

    @Override
    public void progressChanged(MediaHttpDownloader mediaHttpDownloader) {

        switch (mediaHttpDownloader.getDownloadState()) {
            case NOT_STARTED:
                log.info("Não iniciado");
                break;
            case MEDIA_IN_PROGRESS:
                log.info("Download em progresso: {}", mediaHttpDownloader.getProgress());
                break;
            case MEDIA_COMPLETE:
                log.info("Download completo!");
                break;
        }

    }
}
