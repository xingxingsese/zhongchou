package com.lsc.controller;

import com.lsc.api.AdminService;
import com.lsc.bean.TAdmin;
import com.lsc.bean.TMenu;
import com.lsc.constant.AppEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lishuchao
 * @date 2020-04-18 20:44
 */
@Controller
public class LoginController {


    @Autowired
    AdminService adminService;

    @PostMapping("/doLogin")
    public String login(String username, String password, HttpSession httpSession, Model model) {
        Logger logger = LoggerFactory.getLogger(LoginController.class);

        TAdmin admin = adminService.login(username, password);

        if (admin != null) {
            logger.info("{}用户登入成功", username, password);

            httpSession.setAttribute(AppEnum.LOGIN_USER_SESSION_KEY.getKey(), admin);

            // 重定向完全解决重复提交,重定向不能访问受保护的资源
            return "redirect:/main.html";
        }
        logger.info("{}登入失败", username);
        // 登入失败提示信息
        model.addAttribute(AppEnum.PAGE_MSG_KEY.getKey(), "帐号密码错误请重试");
        // 回显
        model.addAttribute("username", username);
        // 登入不成功,转发到登录页面,提示帐号密码错误
        return "forward:/login.jsp";

        // forward转发  redirect重定向 ,视图解析器都不会拼接
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {

        TAdmin loginUser = (TAdmin) session.getAttribute(AppEnum.LOGIN_USER_SESSION_KEY.getKey());

        if (null != loginUser) {
            // 动态的去数据库查出菜单
            List<TMenu> menuList = adminService.listMenus();
            session.setAttribute(AppEnum.MENU_SESSION_KEY.getKey(), menuList);
            // 登入成功跳转到main页面
            return "main";
        }
        // 没登入跳转到登录页面
        model.addAttribute(AppEnum.PAGE_MSG_KEY.getKey(), "请先登录");
        return "forward:/login.jsp";
    }
}
