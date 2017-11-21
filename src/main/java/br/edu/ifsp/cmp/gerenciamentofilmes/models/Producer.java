package br.edu.ifsp.cmp.gerenciamentofilmes.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name = "PRODUTORAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Producer extends AbstractModel{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "Nome da Produtora é obrigatório")
    private String name;

    public Long getId(){
        return  this.id;
    }


    public void clone(AbstractModel object) {
        Producer producer = (Producer) object;
        this.name = producer.getName();
    }
}
