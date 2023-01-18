package com.itAcademy.ssh.dao;

import com.itAcademy.ssh.exception.DaoException;

public interface UserDao {
    boolean authenticate(String login,String password) throws DaoException;
}
