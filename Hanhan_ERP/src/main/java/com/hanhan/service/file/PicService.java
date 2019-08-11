package com.hanhan.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PicService {
    Map<String, Object> picUpload(MultipartFile uploadFile);

    Map<String, String> picDelete(String picName);
}
