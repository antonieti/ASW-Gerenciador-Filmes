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

@Entity(name = "USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends AbstractModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "nome")
    @NotBlank(message = "Nome do usuário é obrigatório.")
    private String name;

    @Column(nullable = false, name = "usuario")
    @NotBlank(message = "Campo usuário é obrigatório.")
    private String userName;

    @Column(nullable = false, name = "senha")
    @NotBlank(message = "Senha é obrigatório.")
    private String password;

    @Override
    public void clone(AbstractModel object) {
        User us = (User) object;
        this.name = us.getName();
        this.password = us.getPassword();
        this.userName = us.getUserName();

    }
}
