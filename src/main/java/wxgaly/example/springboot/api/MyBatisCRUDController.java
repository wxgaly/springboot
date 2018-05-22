package wxgaly.example.springboot.api;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wxgaly.example.springboot.pojo.JSONResult;
import wxgaly.example.springboot.pojo.SysUser;
import wxgaly.example.springboot.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MyBatisCRUDController
 * @Description TODO
 * @Author WXGALY
 * @Date 2018-05-23 0:04
 * @Version 1.0
 */
@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public JSONResult saveUser() throws Exception {

        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("imooc" + new Date());
        user.setNickname("imooc" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public JSONResult updateUser() {

        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUsername("10011001-updated" + new Date());
        user.setNickname("10011001-updated" + new Date());
        user.setPassword("10011001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/deleteUser")
    public JSONResult deleteUser(String userId) {

        userService.deleteUser(userId);

        return JSONResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public JSONResult queryUserById(String userId) {

        return JSONResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public JSONResult queryUserList() {

        SysUser user = new SysUser();
        user.setUsername("imooc");
        user.setNickname("lee");

        List<SysUser> userList = userService.queryUserList(user);

        return JSONResult.ok(userList);
    }

//    @RequestMapping("/queryUserListPaged")
//    public JSONResult queryUserListPaged(Integer page) {
//
//        if (page == null) {
//            page = 1;
//        }
//
//        int pageSize = 10;
//
//        SysUser user = new SysUser();
////		user.setNickname("lee");
//
//        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
//
//        return JSONResult.ok(userList);
//    }

//    @RequestMapping("/queryUserByIdCustom")
//    public JSONResult queryUserByIdCustom(String userId) {
//
//        return JSONResult.ok(userService.queryUserByIdCustom(userId));
//    }

//    @RequestMapping("/saveUserTransactional")
//    public JSONResult saveUserTransactional() {
//
//        String userId = sid.nextShort();
//
//        SysUser user = new SysUser();
//        user.setId(userId);
//        user.setUsername("lee" + new Date());
//        user.setNickname("lee" + new Date());
//        user.setPassword("abc123");
//        user.setIsDelete(0);
//        user.setRegistTime(new Date());
//
//        userService.saveUserTransactional(user);
//
//        return JSONResult.ok("保存成功");
//    }

}
