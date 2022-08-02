package com.upworkscraper.upworkscraper.services;

public interface IService<T> {

    T findById(Long id);

    T insert(T obj);

    T update(Long id, T obj);
}
