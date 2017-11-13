package br.edu.ifsp.cmp.gerenciamentofilmes.dao;

import java.util.List;

public interface BaseDAO <T>{

    void create(T object);

    T read(Long id);

    List<T> read(String parameter);

    void update(T object);

    void delete(T object);

}
