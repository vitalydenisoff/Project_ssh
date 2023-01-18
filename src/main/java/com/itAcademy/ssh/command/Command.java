package com.itAcademy.ssh.command;

import com.itAcademy.ssh.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
@FunctionalInterface
public interface Command {
    Router execute(HttpServletRequest request) throws CommandException;

}
