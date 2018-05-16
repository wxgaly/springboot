package wxgaly.example.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import wxgaly.example.springboot.resource.Resource;

/**
 * @ClassName FreemarkerController
 * @Description TODO
 * @Author WXGALY
 * @Date 2018-05-17 1:02
 * @Version 1.0
 */
@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }

    @RequestMapping("/center")
    public String center() {
        return "freemarker/center/center";
    }

}
