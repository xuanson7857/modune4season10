package com.ra.model.service;

import java.util.List;

public interface IGeneric<T,ID> {
     List<T> findAll();
    boolean saveOfUpdate(T t);
    T findById(ID id);
    void delete(ID id);
}
