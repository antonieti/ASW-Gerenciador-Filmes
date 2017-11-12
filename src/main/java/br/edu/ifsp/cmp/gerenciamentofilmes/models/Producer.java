package br.edu.ifsp.cmp.gerenciamentofilmes.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "PRODUTORAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "Nome da Produtora é obrigatório")
    private String name;

//    @OneToMany
//    private List<Movie> movie;
}
