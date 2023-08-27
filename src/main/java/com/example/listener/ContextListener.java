package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event){
        LocalDateTime time = LocalDateTime.now();
        event.getServletContext().setAttribute("servletTimeInit",time);
    }
}
