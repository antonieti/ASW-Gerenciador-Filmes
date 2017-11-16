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
import java.util.Date;

@Entity(name = "USUARIO_FILME")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovieList implements BaseModel {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie name;

    @Column(name = "assistido")
    private boolean watched;

    @Column(name = "avaliacao")
    private Long rate;

    @Column(name = "dataAssistido")
    private Date date;

    @Override
    public void clone(AbstractModel object) {

    }

    public String getName(){
        return name.getName();
    }
}
