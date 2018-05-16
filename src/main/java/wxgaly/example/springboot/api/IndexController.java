package wxgaly.example.springboot.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wxgaly.example.springboot.pojo.JSONResult;
import wxgaly.example.springboot.resource.Resource;

@RestController
public class IndexController {

    @Autowired
    private Resource resource;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index() {
        return "Hello Spring Boot！！！";
    }

    @RequestMapping(value = "/index3", method = RequestMethod.GET)
    String index2() {
        return "Hello Spring Boot3！！！";
    }

    @RequestMapping(value = "/getResource", method = RequestMethod.GET)
    public JSONResult getResource() {

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return JSONResult.ok(bean);
    }

}
