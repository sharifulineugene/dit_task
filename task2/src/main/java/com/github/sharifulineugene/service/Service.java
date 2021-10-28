package com.github.sharifulineugene.service;

import java.util.List;

public interface Service<T> {
    /**
     * Возвращает List, в котором содержатся все ДТО
     * */
    List<T> getAll();
    /**
     * Сохраняет в базу данных указанный объект, соответствующий переданному ДТО
     * */
    void save(T object);
    /**
     * Получает ДТО, соответствующий объекту с указанным id
     * */
    T get(int id);

}
