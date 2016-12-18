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
@Table(name = "programacao")
public class Programacao implements Serializable {

    private Integer id;
    private Sala idSala;
    private Filme idFilme;
    private Exibicao idHorario;

    @Id
    @Column(name = "idprogramacao")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "idsala")
    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    @ManyToOne
    @JoinColumn(name = "idfilme")
    public Filme getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Filme idFilme) {
        this.idFilme = idFilme;
    }

    @ManyToOne
    @JoinColumn(name = "idhorario")
    public Exibicao getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Exibicao idHorario) {
        this.idHorario = idHorario;
    }

}
