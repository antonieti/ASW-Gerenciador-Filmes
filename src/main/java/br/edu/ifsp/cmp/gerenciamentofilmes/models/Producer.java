package br.edu.ifsp.cmp.gerenciamentofilmes.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
public class Producer implements BaseModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "Nome da Produtora é obrigatório")
    private String name;

    public void clone(AbstractModel object) {

    }
}
