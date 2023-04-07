package com.li.reggie.controller;

import com.li.reggie.commen.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;

    /**
     * ファイルのアップロード
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){

        String originalFilename = file.getOriginalFilename();
        //UUIDを利用し、ファイルの名前をランダム生成する。上書きを防ぐため。
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        String fileName = UUID.randomUUID().toString() + suffix;
        //ディレクトリをクリエイトする
        File dir = new File(basePath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        try {
            file.transferTo(new File(basePath + fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        return R.success(fileName);
    }

    /**
     * ダウンロード
     * @param name
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        try {
            //stream ファイルを読み込む
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
            //outputStream website show pictures
            ServletOutputStream OutputStream = response.getOutputStream();

            response.setContentType("image/jpeg");
            int len = 0;
            byte [] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1){
                OutputStream.write(bytes,0,len);
                OutputStream.flush();
            }
            OutputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
