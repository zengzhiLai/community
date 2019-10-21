package cn.lnsf.community.controller;

import cn.lnsf.community.dto.FileDTO;
import cn.lnsf.community.provider.QcloudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 文件上传
 * @author ：zengzhilai
 * @date ：Created in 2019-10-21 14:20
 */
@Controller
public class FileController {

    @Autowired
    QcloudProvider qcloudProvider;

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request){
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
        try {
            qcloudProvider.upload(file.getInputStream(), file.getContentType(), file.getOriginalFilename());
        }catch (IOException e){
            e.printStackTrace();
        }
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/images/zhi.png");
        return fileDTO;
    }
}
