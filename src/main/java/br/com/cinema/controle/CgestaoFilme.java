package br.com.cinema.controle;

import br.com.cinema.modelo.Filme;
import br.com.cinema.repositorio.FilmeRepositorio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class CgestaoFilme {

    @Inject
    private FilmeRepositorio filmeRepositorio;
    @Inject
    private CcadastroFilme ccadastroFilme;

    private boolean flagShow;
    private boolean flagShowIncluir;
    private Filme filme;
    private List<Filme> listaFilmes;

    @PostConstruct
    public void onCreate() {
        setFlagShow(true);
        setFlagShowIncluir(false);
        limpar();
    }

    public void limpar() {
        listaFilmes = filmeRepositorio.buscarFilmes();
    }

    public void incluir() {
        setFlagShow(false);
        setFlagShowIncluir(true);
    }

    /* GETS E SETS */
    public boolean isFlagShow() {
        return flagShow;
    }

    public void setFlagShow(boolean flagShow) {
        this.flagShow = flagShow;
    }

    public boolean isFlagShowIncluir() {
        return flagShowIncluir;
    }

    public void setFlagShowIncluir(boolean flagShowIncluir) {
        this.flagShowIncluir = flagShowIncluir;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }
}
