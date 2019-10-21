package cn.lnsf.community.provider;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author ：zengzhilai
 * @date ：Created in 2019-10-21 17:06
 */
@Service
public class QcloudProvider {

    @Value("${qcloud.secret.id}")
    private String secretId;
    @Value("${qcloud.secret.key}")
    private String secretKey;

    @Value("${qcloud.bucket.name}")
    private String bucketName;

    @Value("${qcloud.region.name}")
    private String regionName;

    /**
     *
     * @param fileStream 文件流
     * @param mimeType 文件类型
     * @param fileName 文件名称
     * @return
     */
    public String upload(InputStream fileStream, String mimeType, String fileName) {
        String generatedFileName;
        String[] filePaths = fileName.split("\\.");
        if (filePaths.length > 1) {
            generatedFileName = UUID.randomUUID().toString() + "." + filePaths[filePaths.length - 1];
        } else {
            return null;
        }
        // 初始化用户身份信息（secretId, secretKey）
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 设置 bucket 的区域
        Region region = new Region(regionName);
        ClientConfig clientConfig = new ClientConfig(region);
        // 生成 cos 客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        // 设置 Content type, 默认是 application/octet-stream
        objectMetadata.setContentType(mimeType);

        /**
         * putObject() 上传对象到指定的存储桶中
         * @param bucketName 存储桶的名称
         * @param generatedFileName 对象键（Key），是对象在存储桶中的唯一标识
         * @param fileStream 流文件
         * @param objectMetadata 文件的元数据 setContentLength设置输入流长度，setContentType设置网络文件的类型和网页的编码
         * @return
         */
        PutObjectResult response = cosClient.putObject(bucketName, generatedFileName, fileStream, objectMetadata);
        return response.getETag();

    }
}
