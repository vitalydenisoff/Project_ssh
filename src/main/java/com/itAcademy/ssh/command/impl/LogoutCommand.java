package com.itAcademy.ssh.command.impl;

import com.itAcademy.ssh.command.Command;
import com.itAcademy.ssh.command.PagePath;
import com.itAcademy.ssh.command.Router;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogoutCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public Router execute(HttpServletRequest request) {
        logger.info("Hello logout");
        Router router=new Router();
        HttpSession session= request.getSession();
        session.invalidate();
        router.setRedirect();
        router.setPage(PagePath.INDEX);
        return router;
    }
}
