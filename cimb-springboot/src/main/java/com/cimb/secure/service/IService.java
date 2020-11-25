package com.cimb.secure.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<T> {

    Page<T> findAll(Pageable pageable);

    T findById(Long id);

    T saveOrUpdate(T t);

    Boolean deleteById(Long id);
}
