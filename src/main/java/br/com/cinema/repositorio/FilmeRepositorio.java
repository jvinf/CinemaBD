package br.com.cinema.repositorio;

import br.com.cinema.modelo.Filme;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class FilmeRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public List<Filme> buscarFilmes() {
        return manager.createQuery("from Filme", Filme.class).getResultList();
    }

    public Filme porId(Integer id) {
        return manager.find(Filme.class, id);
    }

    public Filme guardar(Filme filme) {
        EntityTransaction trx = manager.getTransaction();

        trx.begin();
        filme = manager.merge(filme);
        trx.commit();

        return filme;
    }

    public void removerFilme(Filme filme) {
        EntityTransaction trx = manager.getTransaction();

        trx.begin();
        filme = porId(filme.getId());
        manager.remove(filme);
        trx.commit();
    }
}
