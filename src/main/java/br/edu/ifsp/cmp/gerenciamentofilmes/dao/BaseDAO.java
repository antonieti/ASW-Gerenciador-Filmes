package br.edu.ifsp.cmp.gerenciamentofilmes.dao;

import br.edu.ifsp.cmp.gerenciamentofilmes.models.AbstractModel;
import br.edu.ifsp.cmp.gerenciamentofilmes.models.Movie;

import java.util.List;

public interface BaseDAO {

    public void save(AbstractModel object) ;

    public void update(AbstractModel m, Long id) ;

    public Movie findById(Long id) ;

    public List findFrom(String column, String parameter);

    public List findAll() ;

    void remove(AbstractModel object) ;

    public void removeId(Long id);
}
