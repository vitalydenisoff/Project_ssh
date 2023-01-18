package com.itAcademy.ssh.service;

import com.itAcademy.ssh.exception.ServiceException;

public interface UserService {
    boolean register(String name, String surname,String dateOfExpirity,String identificationNumber,
                     String email,String password) throws ServiceException;

    boolean authenticate(String email, String password) throws ServiceException;

}
