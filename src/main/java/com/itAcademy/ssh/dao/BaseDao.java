package com.itAcademy.ssh.dao;

import com.itAcademy.ssh.entity.AbstractEntity;
import com.itAcademy.ssh.exception.DaoException;


import java.util.List;

public abstract class BaseDao<T extends AbstractEntity> {
    public  abstract  boolean insert(T t) throws DaoException;
    public  abstract  boolean delete(T t) throws DaoException;
    public abstract List<T> findAll(T t) throws DaoException;
    public abstract T update(T t) throws DaoException;
}
