package com.wutao.usercenter.service;

import com.wutao.usercenter.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 用户服务测试
 *
 * @author wutao
 */
@SpringBootTest
class UserServiceTest {


    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("testwutao");
        user.setUserAccount("1234");
        user.setAvatarUrl("");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);

    }

    @Test
    void userRegister() {
        //测试非空
        String userAccount = "MQQQ";
        String userPassword = "";
        String checkPassword = "12345678";
        String plantCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, plantCode);
        Assertions.assertEquals(-1, result);
        //测试账户长度小于4
        userAccount = "MQQ";
        result = userService.userRegister(userAccount, userPassword, checkPassword, plantCode);
        Assertions.assertEquals(-1,result);
        //测试密码小于6位
        userAccount = "MQQQ";
        userPassword = "12345";
        result = userService.userRegister(userAccount, userPassword, checkPassword, plantCode);
        Assertions.assertEquals(-1, result);
        //测试特殊字符
        userAccount = "MQQQ@";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, plantCode);
        Assertions.assertEquals(-1, result);
        //测试密码和校验密码不相同
        userAccount = "MQQQ";
        checkPassword = "1234567899";
        result = userService.userRegister(userAccount, userPassword, checkPassword, plantCode);
        Assertions.assertEquals(-1, result);
        //测试账号不重复
        userAccount = "MQQQ";
        userPassword = "";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, plantCode);
        Assertions.assertEquals(-1, result);
        //插入数据
        userAccount = "wutao";
        userPassword = "123456789";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, plantCode);
        Assertions.assertTrue(result > 0);



    }
}