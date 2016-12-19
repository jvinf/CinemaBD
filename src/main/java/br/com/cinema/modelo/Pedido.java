package br.com.cinema.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private Integer id;
    private Ingresso idIngresso;

    @Id
    @Column(name = "idpedido")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "idingresso")
    public Ingresso getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(Ingresso idIngresso) {
        this.idIngresso = idIngresso;
    }

}
