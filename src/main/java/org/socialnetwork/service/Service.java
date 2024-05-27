package org.socialnetwork.service;

import java.util.List;

public interface Service<T> {
    List<T> getAll();

    T getById(int id);
}
