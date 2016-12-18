package br.com.cinema.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingresso")
public class Ingresso implements Serializable {

    private Integer id;
    private Programacao idProgramacao;
    private TipoIngresso idTipoIngresso;

    @Id
    @Column(name = "idingresso")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "idprogramacao")
    public Programacao getIdProgramacao() {
        return idProgramacao;
    }

    public void setIdProgramacao(Programacao idProgramacao) {
        this.idProgramacao = idProgramacao;
    }

    @ManyToOne
    @JoinColumn(name = "idtipoingresso")
    public TipoIngresso getIdTipoIngresso() {
        return idTipoIngresso;
    }

    public void setIdTipoIngresso(TipoIngresso idTipoIngresso) {
        this.idTipoIngresso = idTipoIngresso;
    }
}
