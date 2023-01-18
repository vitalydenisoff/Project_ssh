package com.itAcademy.ssh.command.impl;


import com.itAcademy.ssh.command.*;
import com.itAcademy.ssh.exception.CommandException;
import com.itAcademy.ssh.exception.ServiceException;
import com.itAcademy.ssh.service.UserService;
import com.itAcademy.ssh.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class AddUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router=new Router();
        String page;
        String name=request.getParameter(ParameterName.NAME);
        String surname=request.getParameter(ParameterName.SURNAME);
        String dateOfExpirity= request.getParameter(ParameterName.DATE_OF_EXPIRITY);
        String identificationNumber=request.getParameter(ParameterName.IDENTIFICATION_NUMBER);
        String eMail=request.getParameter(ParameterName.E_MAIL);
        String password=request.getParameter(ParameterName.PASSWORD);
        UserService userService= UserServiceImpl.getInstance();
        try {
            if( (userService.register(name,surname,dateOfExpirity,identificationNumber,eMail,password)) ){
    //            request.setAttribute("user",name);
                router.setRedirect();
                page = PagePath.MAIN;
                router.setPage(page);
            } else {
                request.setAttribute(AttributeName.LOGIN_MSG,"incorrect login or password");
                page = PagePath.REGISTER;
                router.setPage(page);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return router;
    }



}
