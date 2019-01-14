package com.asq.cloud.zuulfileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/11 11:28
 * @description TODO
 **/
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(@RequestParam(value = "file",required = true)MultipartFile file){
        try {
            byte[] bytes=file.getBytes();
            File fileToSave=new File(file.getOriginalFilename());
            FileCopyUtils.copy(bytes,fileToSave);
            return fileToSave.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }
}
