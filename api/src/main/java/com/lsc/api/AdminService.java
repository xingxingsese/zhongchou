package com.lsc.api;

import com.lsc.bean.TAdmin;
import com.lsc.bean.TMenu;

import java.util.List;

/**
 * @author lishuchao
 * @date 2020-04-19 21:08
 */
public interface AdminService {


    TAdmin login(String username, String password);

    List<TMenu> listMenus();

    // 查出系统所有的用户
    List<TAdmin> listAllAdmin();

    // 查询带条件的用户
    List<TAdmin> listAllAdminByCondition(String condition);

    // 根据id查出用户
    TAdmin getAdminById(Integer id);

    // 按照id修改admin
    Integer updateAdmin(TAdmin admin);

    // 添加用户
    Integer addAdmin(TAdmin admin);
}
