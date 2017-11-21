package br.edu.ifsp.cmp.gerenciamentofilmes.dao;


import br.edu.ifsp.cmp.gerenciamentofilmes.models.AbstractModel;

import java.util.List;

public interface BaseDAO {

    public void save(AbstractModel object) ;

    public void update(AbstractModel m, Long id) ;

    public AbstractModel findById(Long id) ;

    public List findFrom(String column, String parameter);

    public List findAll() ;

    void remove(AbstractModel object) ;

    public void removeId(Long id);
}
