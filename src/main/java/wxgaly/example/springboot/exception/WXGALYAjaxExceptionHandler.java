package wxgaly.example.springboot.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wxgaly.example.springboot.pojo.JSONResult;

import javax.servlet.http.HttpServletRequest;

/**
 * wxgaly.example.springboot.exception.WXGALYAjaxExceptionHandler
 *
 * @author Created by WXG on 2018/5/21 021 11:52.
 * @version V1.0
 */
//@RestControllerAdvice
public class WXGALYAjaxExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
    public JSONResult defaultErrorHandler(HttpServletRequest req,
                                          Exception e) throws Exception {

        e.printStackTrace();
        return JSONResult.errorException(e.getMessage());
    }

}
