package com.wutao.usercenter.service;

import com.wutao.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 用户服务
 *
 *
 * @author wutao
 */



public interface UserService extends IService<User> {

    /**
     * 用户注释
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @param plantCode 星球编码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String plantCode);

    /**
     *用户登录
     *
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param request session
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    int userLogout(HttpServletRequest request);
}
