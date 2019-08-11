package com.hanhan.controller.file;

import com.hanhan.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("file")
public class FileController {
    @Autowired
    FileService fileService;
    /*直接静态资源映射即可，不过乱码文件没有解决*/
    @RequestMapping("download")
    public String fileDownload(String fileName){
        return fileName;
    }

    @RequestMapping("upload")
    @ResponseBody
    public Map<String,Object> fileUpload(MultipartFile file) throws IOException {

        return fileService.fileUpload(file);

    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String,String> fileDelete(String fileName){
        return fileService.fileDelete(fileName);
    }


}
