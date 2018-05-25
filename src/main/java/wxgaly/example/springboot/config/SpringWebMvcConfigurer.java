package wxgaly.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import wxgaly.example.springboot.api.interceptor.OneInterceptor;
import wxgaly.example.springboot.api.interceptor.TwoInterceptor;

/**
 * wxgaly.example.springboot.config.SpringWebMvcConfigurer
 *
 * @author Created by WXG on 2018/5/25 025 10:28.
 * @version V1.0
 */

@Configuration
public class SpringWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
                .addPathPatterns("/one/**");
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");

    }

}
