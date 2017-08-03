package com.fxiaoke.dbcloud.web;

import com.github.autoconf.spring.reloadable.ReloadableProperty;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 首页
 */
@Controller
public class HomeController {
    @ReloadableProperty("casServerUrlPrefix")
    private String casServerUrlPrefix = "/cas";
    private String unauthorized = "prompt/unauthorized";
    private String home = "home";

    @RequestMapping("/logout")
    public String logout(RedirectAttributes r) {
        SecurityUtils.getSubject().logout();
        r.addFlashAttribute("message", "您已经安全退出");
        return "redirect:" + casServerUrlPrefix + "/logout";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return unauthorized;
    }

    @RequestMapping(value = {"/", "/home"})
    public String hme() {
        return home;
    }
}
