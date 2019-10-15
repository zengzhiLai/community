package cn.lnsf.community.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：赖增智
 * @date ：Created in 2019-9-28 20:26
 */
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns() 对哪些文件进行拦截
        // excludePathPatterns() 不对哪些文件拦截
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }
}