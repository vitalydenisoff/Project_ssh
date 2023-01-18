package com.itAcademy.ssh.command.impl;


import com.itAcademy.ssh.command.*;
import com.itAcademy.ssh.exception.CommandException;
import com.itAcademy.ssh.exception.ServiceException;
import com.itAcademy.ssh.service.UserService;
import com.itAcademy.ssh.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router=new Router();
        HttpSession session=request.getSession();
        String login=request.getParameter(ParameterName.E_MAIL);
        String password=request.getParameter(ParameterName.PASSWORD);
        UserService userService= UserServiceImpl.getInstance();
        String page;
        try {
            if( (userService.authenticate(login,password)) ){
                request.setAttribute(AttributeName.USER,login);
                session.setAttribute(AttributeName.USER,login);
                page = PagePath.MAIN;
                router.setRedirect();
                router.setPage(page);
            } else {
                request.setAttribute(AttributeName.LOGIN_MSG,"incorrect login or password");
                page = PagePath.INDEX;
                router.setPage(page);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return router;
    }
}
