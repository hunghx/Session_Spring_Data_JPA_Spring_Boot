package ra.academy.service;

import jdk.tools.jlink.internal.TaskHelper;

import java.util.List;
import java.util.Optional;

public interface IGenericService <T,E>{
    List<T> findAll();
    T findById(E id);
    T save(T t);
    T update(T t,E id);
    T delete(E i);
}
