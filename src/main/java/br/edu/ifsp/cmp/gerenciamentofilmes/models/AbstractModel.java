package br.edu.ifsp.cmp.gerenciamentofilmes.models;


public abstract class AbstractModel {

    public abstract Long getId();

    public abstract void setId(Long id);

    public abstract void clone(AbstractModel object);


}
