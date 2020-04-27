package com.lsc.controller.permission;


import com.lsc.api.AdminService;
import com.lsc.bean.TAdmin;
import com.lsc.constant.AppEnum;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;

/**
 * 用户所有操作
 * @author lishuchao
 * @date 2020-04-25 23:53
 */
@Controller
public class AdminCrudController {

    Logger logger = LoggerFactory.getLogger(AdminCrudController.class);

    @Autowired
    AdminService adminService;


    /**
     * 跳转到用户修改页
     *
     * @return
     */
    @GetMapping("/user/edit.html")
    public String toEditPage(@RequestParam("id") Integer id, Model model) {

        TAdmin admin = adminService.getAdminById(id);
        model.addAttribute("data", admin);

        return "permission/user-edit";
    }

    /**
     * 用户修改
     *
     * @return
     */
    @PostMapping("/user/update")
    public String adminUpdate(TAdmin admin,HttpSession session,Model model) {

        Integer updateResult = adminService.updateAdmin(admin);

        // 获取到当前修改的页码
        Integer pn = (Integer) session.getAttribute(AppEnum.PAGE_NUMBER_KEY.getKey());
        // 获取当前的查询条件
        String cn = (String) session.getAttribute(AppEnum.QUERY_CONDITION_KEY.getKey());
        model.addAttribute(AppEnum.PAGE_NUMBER_KEY.getKey()).addAttribute(AppEnum.QUERY_CONDITION_KEY.getKey());

        // 修改成功后重新回到修改页
        return "redirect:/admin/index.html";
    }

    /**
     *跳转到用户添加页
     */
    @GetMapping("/user/add.html")
    public String toAddAdmin(){

        return "permission/user-add";
    }

    /**
     * 添加用户
     */
    @PostMapping("/user/add")
    public String addAdmin(TAdmin admin){

        Integer addResult =  adminService.addAdmin(admin);
        logger.debug("当前要添加的用户信息为:{}",admin);
        return "redirect:/user/add.html?pn="+Integer.MAX_VALUE;
    }

}
