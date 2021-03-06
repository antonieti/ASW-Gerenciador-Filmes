package br.edu.ifsp.cmp.gerenciamentofilmes.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity(name = "FILMES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends AbstractModel{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produtora_id")
    private Producer producer;

    @Column(name = "genero")
    private String genre;

    @Column(name = "ano")
    private Short year;

    @Column(nullable = false, name = "nome")
    @NotBlank(message = "Nome do Movie é obrigatório.")
    private String name;

    public Movie(String movie, Short year, Producer producer) {
        this.name = movie;
        this.year = year;
        this.producer = producer;
    }


    public void clone(AbstractModel object) {
        Movie obj  = (Movie) object;
        this.name = obj.getName();
        this.year= obj.getYear();
        this.producer=obj.getProducer();
    }
}
