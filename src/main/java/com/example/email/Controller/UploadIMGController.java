package com.example.email.Controller;

import com.example.email.ModelDTO.UploadImagesDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UploadIMGController {
    @Value("${imgUri}")
    private  String filePath ;
    @Value("${imagesService.host}")
    private String imgHost;

    @RequestMapping(value = "/upload")
    @ResponseBody
    public UploadImagesDTO  upload(@RequestParam("file")List<MultipartFile>  file, HttpServletRequest request) {
        UploadImagesDTO uploadImagesDTO=new UploadImagesDTO();
        List<String> data = new ArrayList<>();
        for (MultipartFile file1:file) {
            //file.isEmpty(); 判断图片是否为空
            //file.getSize(); 图片大小进行判断
            String name = request.getParameter("name");
            System.out.println("用户名：" + name);

            // 获取文件名
            String fileName = file1.getOriginalFilename();
            System.out.println("上传的文件名为：" + fileName);

            // 获取文件的后缀名,比如图片的jpeg,png
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("上传的后缀名为：" + suffixName);

            // 文件上传后的路径
            fileName = UUID.randomUUID().toString() + suffixName;

            System.out.println("转换后的名称:" + fileName);

            File dest = new File(filePath + "img/" + fileName);

            try {
                file1.transferTo(dest);

                data.add(imgHost + "/file/img/" + fileName);
                uploadImagesDTO.setData(data);
                uploadImagesDTO.setErrno(0);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return  uploadImagesDTO;
    }
}
