package com.itAcademy.ssh.command.impl;

import com.itAcademy.ssh.command.Command;
import com.itAcademy.ssh.command.PagePath;
import com.itAcademy.ssh.command.Router;
import jakarta.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router=new Router();
        router.setPage(PagePath.INDEX);
        return router;
    }
}
