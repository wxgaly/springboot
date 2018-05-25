package wxgaly.example.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wxgaly.example.springboot.pojo.JSONResult;
import wxgaly.example.springboot.pojo.SysUser;
import wxgaly.example.springboot.pojo.User;
import wxgaly.example.springboot.utils.JsonUtils;
import wxgaly.example.springboot.utils.RedisOperator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * wxgaly.example.springboot.api.RedisController
 *
 * @author Created by WXG on 2018/5/25 025 9:27.
 * @version V1.0
 */

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public JSONResult test() {

        strRedis.opsForValue().set("wxgaly-cache", "hello 慕课网~~~~~~");

        SysUser user = new SysUser();
        user.setId("100111");
        user.setUsername("wxgaly");
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));

        SysUser jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), SysUser.class);

        return JSONResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public JSONResult getJsonList() {

        User user = new User();
        user.setAge(18);
        user.setName("慕课网");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User u1 = new User();
        u1.setAge(19);
        u1.setName("wxgaly");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("hello wxgaly");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);

        String userListJson = redis.get("json:info:userlist");
        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);

        return JSONResult.ok(userListBorn);
    }
}