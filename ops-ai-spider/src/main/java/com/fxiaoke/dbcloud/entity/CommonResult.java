package com.fxiaoke.dbcloud.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by libn on 2016/9/6.
 */
@Getter
@Setter
@NoArgsConstructor
public class CommonResult {

    public static final int SUCCESS = 0;
    public static final int FAIL = -1;
//    public static final int WARN = 1;

    private String msg = "";
    private int code = FAIL;
    private Object data;

    public boolean isErr() {
        return code == FAIL || code != SUCCESS;
    }

    public boolean isSuc() {
        return code == SUCCESS;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
