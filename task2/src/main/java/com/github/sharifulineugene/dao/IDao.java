package com.github.sharifulineugene.dao;

import com.github.sharifulineugene.entity.Account;

import java.util.List;

public interface IDao<T> {
    /**
     * Возвращает List всех объектов из базы данных
     * */
    List<T> index();
    /**
     * Сохраняет полученный объект в базу данных
     * */
    void save(T object);
    /**
     * Возвращает объект из базы данных с указанным id
     * */
    T show(int id);

}
