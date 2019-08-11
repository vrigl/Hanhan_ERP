package com.hanhan.controller.file;

import com.hanhan.service.file.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("pic")
public class PicController {

    @Autowired
    PicService picService;
    @RequestMapping("delete")
    @ResponseBody
    public Map<String,String> picDelete(String picName){
        return picService.picDelete(picName);
    }



    @RequestMapping("upload")
    @ResponseBody
    public Map<String,Object> picUpload(MultipartFile uploadFile) throws IOException {
         return picService.picUpload(uploadFile);
    }
}
