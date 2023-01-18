package com.itAcademy.ssh.command.impl;


import com.itAcademy.ssh.command.Command;
import com.itAcademy.ssh.command.PagePath;
import com.itAcademy.ssh.command.Router;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegisterCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
    @Override
    public Router execute(HttpServletRequest request) {
        Router router=new Router();
        String page= PagePath.REGISTER;
        router.setPage(page);
        return router;
    }
}
