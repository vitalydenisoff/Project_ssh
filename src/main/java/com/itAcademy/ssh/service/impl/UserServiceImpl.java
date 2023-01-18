package com.itAcademy.ssh.service.impl;

import com.itAcademy.ssh.dao.impl.UserDaoImpl;
import com.itAcademy.ssh.encryption.PasswordEncryption;
import com.itAcademy.ssh.entity.User;
import com.itAcademy.ssh.exception.DaoException;
import com.itAcademy.ssh.exception.ServiceException;
import com.itAcademy.ssh.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();

    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {

    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean register(String name, String surname, String dateOfExpirity, String identificationNumber,
                            String email, String password) throws ServiceException {
        String passwordEncrypted=PasswordEncryption.encrypt(password);
        User user = new User(name, surname, dateOfExpirity, identificationNumber, email, passwordEncrypted);
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match;
        try {
            match = userDao.insert(user);
            return match;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public boolean authenticate(String email, String password) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        String encryptPassword= PasswordEncryption.encrypt(password);
        boolean match = false;
        try {
            match = userDao.authenticate(email,encryptPassword);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return match;
    }

}
