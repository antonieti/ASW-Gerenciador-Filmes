package br.edu.ifsp.cmp.gerenciamentofilmes.models;


import br.edu.ifsp.cmp.gerenciamentofilmes.utils.ConnectionFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
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
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produtora_id")
    private Producer producer;

    @Column(name = "ano")
    private Short year;

    @Column(nullable = false, name = "nome")
    @NotBlank(message = "Nome do Movie é obrigatório.")
    private String name;

    public void insertMovie(){

        Movie m = Movie.builder().name(this.name).year(this.year).producer(this.producer).build();

        EntityManager em = ConnectionFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();

    }

    public void removeMovie(){
        Movie m
                = Movie.builder().name(this.name).year(this.year).producer(this.producer).build();



    }
}
