package com.hanhan.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileService {
    Map<String, Object> fileUpload(MultipartFile file);

    Map<String, String> fileDelete(String fileName);
}
