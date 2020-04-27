package com.lsc.listenr;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author lishuchao
 * 项目监听器
 * @date 2020-04-07 21:36
 */
public class AppStartUpListener implements ServletContextListener {
    /**
     * 项目初始化
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Logger logger = LoggerFactory.getLogger(AppStartUpListener.class);


        ServletContext servletContext = sce.getServletContext();
        // 当前项目路径,
        String contextPath = servletContext.getContextPath();
        servletContext.setAttribute("ctx",contextPath);
        logger.info("当前项目路径为:{}",contextPath);
        System.out.println("******************"+contextPath);
    }

    /**
     * 项目销毁
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
