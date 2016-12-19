package br.com.cinema.repositorio;

import br.com.cinema.modelo.Classificacao;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ClassificacaoRepositorio {

    @Inject
    private EntityManager manager;

    public List<Classificacao> buscarClassificacoes() {
        return manager.createQuery("from Classificacao", Classificacao.class).getResultList();
    }
}
