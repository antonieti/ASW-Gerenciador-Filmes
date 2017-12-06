package br.edu.ifsp.cmp.gerenciamentofilmes.dao;



import java.util.List;

public interface BaseDAO<T> {

    public void save(T object) ;

    public void update(T m, Long id) ;

    public T findById(Long id) ;

    public List findFrom(String column, String parameter);

    public List findAll() ;

    void remove(T object) ;

    public void removeId(Long id);
}
