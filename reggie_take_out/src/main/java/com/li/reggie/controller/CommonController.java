package com.li.reggie.controller;

import com.li.reggie.commen.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/common")
public class CommonController {
//    @Value("${reggie.path}")
    private String basePath = "D:/";

    /**
     * ファイルのアップロード
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        try {
            file.transferTo(new File(basePath + "hello.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
