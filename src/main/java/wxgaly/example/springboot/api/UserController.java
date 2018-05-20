package wxgaly.example.springboot.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wxgaly.example.springboot.pojo.User;

import java.util.Date;

//@Controller
@RestController //RestController == Controller + ResponseBody
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
//    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setAge(22);
        user.setBirthday(new Date());
        user.setName("zhangsan");
        user.setPassword("123456");

        return user;
    }


}
