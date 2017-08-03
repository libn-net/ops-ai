package com.fxiaoke.dbcloud.interceptor;

import com.github.shiro.support.ShiroCasRealm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuw on 2016/7/19.
 */
@Slf4j
public class AuthorityInterceptor implements HandlerInterceptor {
    @Autowired
    private ShiroCasRealm shiroCasRealm;

    private String forbiddenUrl = "/unauthorized";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object o) throws Exception {

        // 返回值，是否拥有权限
        boolean hasPermission = true;
        // 没有权限，跳转到403页面
        if (!hasPermission) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + forbiddenUrl);
        }

        return hasPermission;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o,
                                Exception e) throws Exception {

    }
}
