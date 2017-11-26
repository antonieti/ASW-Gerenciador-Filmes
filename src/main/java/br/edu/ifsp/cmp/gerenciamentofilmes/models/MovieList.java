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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "USUARIO_FILME")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovieList extends AbstractModel{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    @ManyToOne
    private Movie name;

    @Column(name = "assistido")
    private boolean watched;

    @Column(name = "avaliacao")
    private Long rate;




    @Override
    public void clone(AbstractModel object) {
        //it is implemented
        MovieList aux = (MovieList) object;
        this.name = aux.name;
        this.rate = aux.getRate();
        this.user = aux.getUser();
        this.watched = aux.watched;
    }

    public Movie getMovie(){
        return this.name;
    }
    public String getName(){
        return name.getName();
    }
}
