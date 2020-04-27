package com.lsc.utils;

import org.springframework.util.DigestUtils;

/**
 * 加密工具类
 *
 * @author lishuchao
 * @date 2020-04-20 21:21
 */
public class AppUtils {

    public static String getDigestPwd(String str) {
        String digest = str;
        for (int i = 0; i < 100; i++) {

            digest = DigestUtils.md5DigestAsHex(str.getBytes());
        }
        return digest;
    }
}
