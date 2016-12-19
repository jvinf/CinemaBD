package br.com.cinema.controle;

import br.com.cinema.modelo.Classificacao;
import br.com.cinema.modelo.Filme;
import br.com.cinema.modelo.Genero;
import br.com.cinema.repositorio.ClassificacaoRepositorio;
import br.com.cinema.repositorio.GeneroRepositorio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class CcadastroFilme {

    @Inject
    private GeneroRepositorio genero;
    @Inject
    private ClassificacaoRepositorio classificacao;

    private Filme filme;
    private List<Genero> listaGeneros;
    private List<Classificacao> listaClassificacao;

    @PostConstruct
    public void onCreate() {
        filme = new Filme();
        listaGeneros = genero.buscarGeneros();
        listaClassificacao = classificacao.buscarClassificacoes();
    }

    public void limpar() {
        filme = new Filme();
    }

    public void salvar() {

    }

    /* GETS E SETS */
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Genero> getListaGeneros() {
        return listaGeneros;
    }

    public void setListaGeneros(List<Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    public List<Classificacao> getListaClassificacao() {
        return listaClassificacao;
    }

    public void setListaClassificacao(List<Classificacao> listaClassificacao) {
        this.listaClassificacao = listaClassificacao;
    }
}
