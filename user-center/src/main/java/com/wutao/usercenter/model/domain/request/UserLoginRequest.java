package com.wutao.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -6283472727419547618L;
    private String userAccount;

    private String userPassword;
}
