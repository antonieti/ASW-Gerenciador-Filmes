package br.edu.ifsp.cmp.gerenciamentofilmes.models;

public interface BaseModel <T extends BaseModel> {

    public Long getId();

    public void setId(Long id);

    public void clone(AbstractModel object);


}
