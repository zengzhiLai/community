package cn.lnsf.community.controller;

import cn.lnsf.community.dto.FileDTO;
import cn.lnsf.community.provider.QcloudProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传
 * @author ：zengzhilai
 * @date ：Created in 2019-10-21 14:20
 */
@Controller
@Slf4j
public class FileController {

    @Autowired
    private QcloudProvider qcloudProvider;

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request){
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
        try {
            String fileName = qcloudProvider.upload(file.getInputStream(), file.getContentType(), file.getOriginalFilename());
            FileDTO fileDTO = new FileDTO();
            fileDTO.setSuccess(1);
            fileDTO.setUrl(fileName);
            return fileDTO;
        }catch (Exception e){
            log.error("upload error", e);
            FileDTO fileDTO = new FileDTO();
            fileDTO.setSuccess(0);
            fileDTO.setMessage("上传失败");
            return fileDTO;
        }

    }
}
