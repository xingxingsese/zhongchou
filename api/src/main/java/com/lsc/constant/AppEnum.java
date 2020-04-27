package com.lsc.constant;

import java.text.Format;
import java.text.MessageFormat;
import java.util.Formatter;

/**
 * @author lishuchao
 * @date 2020-04-20 20:26
 */
public enum AppEnum {
    LOGIN_USER_SESSION_KEY("loginUser","登入对象域key"),
    PAGE_MSG_KEY("msg","提示消息"),
    MENU_SESSION_KEY("menus","数据库查出的菜单key"),
    QUERY_CONDITION_KEY("condition","查询条件"),
    PAGE_NUMBER_KEY("pn","当前页码")
    ;

    private String key;
    private String desc;


    AppEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey(String... keys) {

        return MessageFormat.format(this.key, keys);

    }

    public String getDesc() {
        return desc;
    }
}
