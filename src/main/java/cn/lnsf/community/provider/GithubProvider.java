package cn.lnsf.community.provider;

import cn.lnsf.community.dto.AccessTokenDTO;
import cn.lnsf.community.dto.GithubUser;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

/**
 * @author ：zengzhilai
 * @date ：Created in 2019-6-1 13:42
 */
@Component
@Slf4j
public class GithubProvider {
    /**
     * 获取accessToken
     *
     * @param accessTokenDTO
     * @return
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        //OKHttp
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];

            System.out.println(string);
            return token;
        } catch (Exception e) {
            log.error("getAccessToken,{}", accessTokenDTO, e);
        }
        return null;
    }

    /**
     * 通过accessToken获取用户信息
     *
     * @param accessToken
     * @return
     */
    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            //parseObject(): 将string的json对象自动解析转换成java的类对象
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;

        } catch (Exception e) {
            log.error("getAccessToken,{}", accessToken, e);
        }
        return null;
    }

}
