package wxgaly.example.springboot.api.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import wxgaly.example.springboot.pojo.JSONResult;
import wxgaly.example.springboot.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * wxgaly.example.springboot.api.interceptor.OneInterceptor
 *
 * @author Created by WXG on 2018/5/25 025 10:31.
 * @version V1.0
 */

public class OneInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object object) throws Exception {

        System.out.println("被one拦截，放行...");
        return true;

		/*if (true) {
			returnErrorResponse(response, IMoocJSONResult.errorMsg("被one拦截..."));
		}

		return false;*/
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView mv)
            throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
     * （主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object object, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

    public void returnErrorResponse(HttpServletResponse response, JSONResult result)
            throws IOException, UnsupportedEncodingException {
        OutputStream out = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out = response.getOutputStream();
            out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
