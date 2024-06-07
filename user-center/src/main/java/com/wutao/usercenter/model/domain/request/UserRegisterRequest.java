package com.wutao.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author wutao
 */

@Data
public class UserRegisterRequest implements Serializable {


    @Serial
    private static final long serialVersionUID = -1907089477060879004L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String plantCode;

}

