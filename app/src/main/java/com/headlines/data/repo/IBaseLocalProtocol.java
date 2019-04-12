package com.headlines.data.repo;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface IBaseLocalProtocol<T> {

     LiveData<List<T>> getAll();
     Long insert(T entity);
     List<Long> insert(List<T> entities);
}
