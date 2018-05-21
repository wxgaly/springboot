package wxgaly.example.springboot.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wxgaly.example.springboot.pojo.JSONResult;

/**
 * wxgaly.example.springboot.api.ErrorController
 *
 * @author Created by WXG on 2018/5/21 021 11:44.
 * @version V1.0
 */

@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {

        int a = 1 / 0;

        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror() {

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public JSONResult getAjaxerror() {

        int a = 1 / 0;

        return JSONResult.ok();
    }
}