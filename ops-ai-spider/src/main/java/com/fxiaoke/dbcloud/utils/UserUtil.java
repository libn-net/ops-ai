package com.fxiaoke.dbcloud.utils;

import com.github.shiro.support.ShiroUser;

import org.apache.shiro.SecurityUtils;

/**
 * 用户工具类
 * Created by libn on 2016/8/15.
 */
public class UserUtil {

    public static String getUserId() {
        ShiroUser user = getUser();
        return user.getUsername();
    }

    public static String getUserName() {
        ShiroUser user = getUser();
        return user.getDisplayName();
    }

    public static ShiroUser getUser() {
        return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }
}
