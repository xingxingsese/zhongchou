package com.lsc.servoce.impl;

import com.lsc.api.AdminService;
import com.lsc.bean.TAdmin;
import com.lsc.bean.TAdminExample;
import com.lsc.bean.TMenu;
import com.lsc.bean.TMenuExample;
import com.lsc.mapper.TAdminMapper;
import com.lsc.mapper.TMenuMapper;
import com.lsc.utils.AppUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author lishuchao
 * @date 2020-04-19 21:10
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    TAdminMapper adminMapper;

    @Autowired
    TMenuMapper menuMapper;

    /**
     * XXXByExample结尾的"代表带复杂条件的crud"
     * XXXByPrimaryKey结尾的"代表用主键进行crud"
     * XXXSelective:代表有选择的插入更新,常见于insert和update,只更新不为null的
     *
     * @param username
     * @param password
     * @return
     */
    Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);


    @Override
    public TAdmin login(String username, String password) {

        logger.info("入参userna为{},password为{}", username, password);
        // 把密码改为密文
        String pwd = AppUtils.getDigestPwd(password);
        logger.info("加密后的password为:{}", pwd);

        TAdminExample example = new TAdminExample();
        example.createCriteria().andLoginacctEqualTo(username).andUserpswdEqualTo(pwd);

        List<TAdmin> list = adminMapper.selectByExample(example);
        logger.info("返回的list为:{}", list);

        return !CollectionUtils.isEmpty(list) && list.size() == 1 ? list.get(0) : null;
    }

    /**
     * 动态查出菜单
     *
     * @return
     */
    @Override
    public List<TMenu> listMenus() {

        TMenuExample tMenuExample = new TMenuExample();
        // 1 查出父菜单
        tMenuExample.createCriteria().andPidEqualTo(0);
        List<TMenu> parentMenus = menuMapper.selectByExample(tMenuExample);

        // 2 查出父菜单的子菜单
        for (TMenu menu : parentMenus) {

            TMenuExample tMenuExample2 = new TMenuExample();
            tMenuExample2.createCriteria().andPidEqualTo(menu.getId());
            List<TMenu> childMenus = menuMapper.selectByExample(tMenuExample2);

            menu.setChilds(childMenus);
        }

        return parentMenus;
    }

    /**
     * 查出所有用户
     *
     * @return
     */
    @Override
    public List<TAdmin> listAllAdmin() {

        return adminMapper.selectByExample(null);
    }

    /**
     * 查询带条件的用户
     *
     * @param condition
     * @return
     */
    @Override
    public List<TAdmin> listAllAdminByCondition(String condition) {
        TAdminExample example = new TAdminExample();
        if (!StringUtils.isEmpty(condition)) {
            TAdminExample.Criteria c1 = example.createCriteria().andLoginacctLike("%" + condition + "%");
            TAdminExample.Criteria c2 = example.createCriteria().andUsernameLike("%" + condition + "%");
            TAdminExample.Criteria c3 = example.createCriteria().andEmailLike("%" + condition + "%");
            example.or(c2);
            example.or(c3);
        }

        return adminMapper.selectByExample(example);
    }

    /**
     * 根据id查出用户
     * @param id
     * @return
     */
    @Override
    public TAdmin getAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 按照id修改用户
     * @param admin
     */
    @Override
    public Integer updateAdmin(TAdmin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin);

    }

    /**
     * 添加用户
     * @param admin
     * @return
     */
    @Override
    public Integer addAdmin(TAdmin admin) {

        return adminMapper.insertSelective(admin);
    }
}
