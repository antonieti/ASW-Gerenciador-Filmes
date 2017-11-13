package br.edu.ifsp.cmp.gerenciamentofilmes.dao;

import javax.persistence.criteria.Order;
import java.io.Serializable;
import java.util.List;

public interface BaseDAO <T>{

    void create(T object);

    T read(Long id);

    List<T> read(T object, String name, String columnName);

    void update(T object, Long id);

    void delete(T object);

}
