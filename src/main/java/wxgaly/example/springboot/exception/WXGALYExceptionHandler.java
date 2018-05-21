package wxgaly.example.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import wxgaly.example.springboot.pojo.JSONResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * wxgaly.example.springboot.exception.IMoocExceptionHandler
 *
 * @author Created by WXG on 2018/5/21 021 11:46.
 * @version V1.0
 */

@ControllerAdvice
public class WXGALYExceptionHandler {

    public static final String WXGALY_ERROR_VIEW = "error";

//    @ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest reqest,
//                               HttpServletResponse response, Exception e) throws Exception {
//
//        e.printStackTrace();
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", reqest.getRequestURL());
//        mav.setViewName(WXGALY_ERROR_VIEW);
//        return mav;
//    }

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) throws Exception {

        e.printStackTrace();

        if (isAjax(reqest)) {
            return JSONResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(WXGALY_ERROR_VIEW);
            return mav;
        }
    }

    /**
     *
     *
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }
}
