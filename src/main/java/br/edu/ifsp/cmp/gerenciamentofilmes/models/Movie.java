package br.edu.ifsp.cmp.gerenciamentofilmes.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity(name = "FILMES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
//    @Column(name = "produtora_id")
    private Producer producer;

    @Column(name = "ano")
    private Short year;

    @Column(nullable = false, name = "nome")
    @NotBlank(message = "Nome do Movie é obrigatório.")
    private String name;
}
