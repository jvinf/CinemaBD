package br.com.cinema.service;

import br.com.cinema.modelo.Filme;
import br.com.cinema.repositorio.FilmeRepositorio;
import java.io.Serializable;

import javax.inject.Inject;

public class CadastroFilmeService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FilmeRepositorio filmes;

    public Filme salvar(Filme filme) {
        return filmes.guardar(filme);
    }
    
    public void remover(Filme filme) {
        filmes.removerFilme(filme);
    }
}
