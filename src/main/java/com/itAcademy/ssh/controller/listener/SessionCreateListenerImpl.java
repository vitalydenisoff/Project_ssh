package com.itAcademy.ssh.controller.listener;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebListener
public class SessionCreateListenerImpl implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

}
