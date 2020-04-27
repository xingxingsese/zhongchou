package com.lsc.controller.permission;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lsc.api.AdminService;
import com.lsc.bean.TAdmin;
import com.lsc.constant.AppEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lishuchao
 * @date 2020-04-18 22:04
 */
@Controller
public class PermissionPageController {

    @Autowired
    AdminService adminService;

    @GetMapping("/user.html")
    public String userPage(){
        return "permission/user";
    }

    @GetMapping("/role.html")
    public String rolePage(){
        return "permission/role";
    }

    /**
     * 跳转到用户维护页面
     * 查出系统中所有用户的tadmin
     * @return
     */
    @GetMapping("/admin/index.html")
    public String adminIndexPage(Model model,
                                 @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                                 @RequestParam(value = "ps",defaultValue = "5")Integer ps,
                                 @RequestParam(value = "condition",defaultValue = "") String condition,
                                 HttpSession session){
        // 将查询条件放在session中
        session.setAttribute(AppEnum.QUERY_CONDITION_KEY.getKey(),condition);

        // 将当前页码放到session中
        session.setAttribute(AppEnum.PAGE_NUMBER_KEY.getKey(),pn);
        PageHelper.startPage(pn,ps);
       // List<TAdmin> admins = adminService.listAllAdmin();
        List<TAdmin> admins = adminService.listAllAdminByCondition(condition);
        PageInfo<TAdmin> page = new PageInfo<>(admins,5);
        model.addAttribute("page",page);
        return "permission/user";
    }
    /**
     * 跳转到角色维护页面
     */
    @GetMapping("/role/index.html")
    public  String roleIndexPage(){
        return "permission/role";
    }
    /**
     * 跳转到权限维护页面
     */
    @GetMapping("/permission/index.html")
    public  String permissionIndexPage(){
        return "permission/permission";
    }

    /**
     * 跳转到菜单维护页面
     */
    @GetMapping("/menu/index.html")
    public  String menuIndexPage(){
        return "permission/menu";
    }

    /**
     * 跳转到实名认证审核页面
     */
    @GetMapping("/auth_cert/index.html")
    public  String auth_CertIndexPage(){
        return "serviceauth/auth_cert";
    }

    /**
     * 跳转到广告审核页面
     */
    @GetMapping("/auth_adv/index.html")
    public  String auth_advIndexPage(){
        return "serviceauth/auth_adv";
    }

    /**
     * 跳转到项目审核页面
     */
    @GetMapping("/auth_project/index.html")
    public  String auth_projectIndexPage(){
        return "serviceauth/auth_project";
    }

    /**
     * 跳转到资质维护页面
     */
    @GetMapping("/cert/index.html")
    public  String cereIndexPage(){
        return "servicemanage/cert";
    }

    /**
     * 跳转到分类管理页面
     */
    @GetMapping("/certtype/index.html")
    public  String certtypeIndexPage(){
        return "servicemanage/type";
    }

    /**
     * 跳转到流程管理页面
     */
    @GetMapping("/process/index.html")
    public  String processIndexPage(){
        return "servicemanage/process";
    }/**
     * 跳转到广告管理页面
     */
    @GetMapping("/advert/index.html")
    public  String advertIndexPage(){
        return "servicemanage/advertisement";
    }/**
     * 跳转到消息模版页面
     */
    @GetMapping("/message/index.html")
    public  String messageIndexPage(){
        return "servicemanage/message";
    }/**
     * 跳转到项目分类页面
     */
    @GetMapping("/projectType/index.html")
    public  String projectTypeIndexPage(){
        return "servicemanage/project_type";
    }/**
     * 跳转到项目标签页面
     */
    @GetMapping("/tag/index.html")
    public  String tagIndexPage(){
        return "servicemanage/tag";
    }

}
