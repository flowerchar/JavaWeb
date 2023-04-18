package com.flowerchar.tliaswebmanagement.controller;

import com.flowerchar.tliaswebmanagement.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{}",image);
        String originalFilename = image.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        image.transferTo(new File("D:\\githubRep\\JavaWeb_Consolidation\\tlias-web-management\\test\\"+newFileName));
        return Result.success();
    }
}
