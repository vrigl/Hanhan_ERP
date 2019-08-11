package com.hanhan.service.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    ServletContext context;

    @Override
    public Map<String, Object> fileUpload(MultipartFile file) {
        String realPath = context.getRealPath("/WEB-INF/file" + file.getOriginalFilename());
        File newFile = new File(realPath);
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, Object> map= new HashMap<>();
        int i = realPath.indexOf("\\file");
        String replace = realPath.substring(i+5).replace("\\", "/");
        map.put("error",0);
        map.put("url",replace);
        return map;
    }

    @Override
    public Map<String, String> fileDelete(String fileName) {
        String realPath = context.getRealPath("/WEB-INF" + fileName);
        File file = new File(realPath);
        file.delete();
        Map<String,String> map = new HashMap<>();
        map.put("data", "success");
        return map;
    }
}
