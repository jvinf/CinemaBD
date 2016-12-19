package br.com.cinema.repositorio;

import br.com.cinema.modelo.Filme;
import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class FilmeRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Filme guardar(Filme filme) {
        EntityTransaction trx = manager.getTransaction();

        trx.begin();
        filme = manager.merge(filme);
        trx.commit();

        return filme;
    }
}
