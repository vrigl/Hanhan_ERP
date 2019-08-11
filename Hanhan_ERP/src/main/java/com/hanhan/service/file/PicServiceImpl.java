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
public class PicServiceImpl implements PicService {
    @Autowired
    ServletContext context;
    @Override
    public Map<String, Object> picUpload(MultipartFile uploadFile) {

        String path = context.getRealPath("/WEB-INF/pic/" + uploadFile.getOriginalFilename());
        File file = new File(path);
        try {
            uploadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, Object> map = new HashMap<>();
        int i = path.indexOf("\\pic");
        String replace = path.substring(i).replace("\\", "/");

        map.put("error",0);
        map.put("url",replace);
        return map;
    }

    @Override
    public Map<String, String> picDelete(String picName) {
        String realPath = context.getRealPath("/WEB-INF" + picName);
        File file = new File(realPath);
        file.delete();
        Map<String,String> map = new HashMap<>();
        map.put("data", "success");
        return map;
    }
}
