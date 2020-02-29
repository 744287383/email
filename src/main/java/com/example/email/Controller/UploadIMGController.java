package com.example.email.Controller;

import com.example.email.ModelDTO.UploadImagesDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Configuration
public class UploadIMGController {
    @Value("${saveImgPath}")
    private  String filePath ;


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public UploadImagesDTO  upload(MultipartFile file, HttpServletRequest request) {
        UploadImagesDTO uploadImagesDTO=new UploadImagesDTO();



                //file.isEmpty(); 判断图片是否为空
                //file.getSize(); 图片大小进行判断
                String name = request.getParameter("name");
                System.out.println("用户名：" + name);

                // 获取文件名
                String fileName = file.getOriginalFilename();
                System.out.println("上传的文件名为：" + fileName);

                // 获取文件的后缀名,比如图片的jpeg,png
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                System.out.println("上传的后缀名为：" + suffixName);

                // 文件上传后的路径
                fileName = UUID.randomUUID() + suffixName;
                System.out.println("转换后的名称:" + fileName);

                File dest = new File(filePath + fileName);

                try {
                    file.transferTo(dest);

                    uploadImagesDTO.getData().add(fileName);
                    uploadImagesDTO.setErrno(0);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


        return  uploadImagesDTO;
    }
}
