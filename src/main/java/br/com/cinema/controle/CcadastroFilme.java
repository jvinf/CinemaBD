package br.com.cinema.controle;

import br.com.cinema.jsf.FacesUtil;
import br.com.cinema.modelo.Classificacao;
import br.com.cinema.modelo.Filme;
import br.com.cinema.modelo.Genero;
import br.com.cinema.repositorio.ClassificacaoRepositorio;
import br.com.cinema.repositorio.GeneroRepositorio;
import br.com.cinema.service.CadastroFilmeService;
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
    @Inject
    private CadastroFilmeService cadastroFilmeService;

    private boolean flagShow;
    private Filme filme;
    private Filme filmeSel;
    private List<Genero> listaGeneros;
    private List<Classificacao> listaClassificacao;

    @PostConstruct
    public void onCreate() {
        setFlagShow(true);
        limpar();
    }

    public void limpar() {
        filme = new Filme();
        listaGeneros = genero.buscarGeneros();
        listaClassificacao = classificacao.buscarClassificacoes();
    }

    public void salvar() {
        cadastroFilmeService.salvar(filme);
        limpar();
        FacesUtil.addInfoMessage("Filme salvo com sucesso!");
    }

    public void alterar() {
        if (filmeSel != null) {
            filme = filmeSel;
        }
    }

    public void excluir() {
        if (filmeSel != null) {
            cadastroFilmeService.remover(filmeSel);
            limpar();
            FacesUtil.addInfoMessage("Filme excluído com sucesso!");
        } else {
            FacesUtil.addErrorMessage("Selecione um filme para excluir!");
        }
    }

    /* GETS E SETS */
    public boolean isFlagShow() {
        return flagShow;
    }

    public void setFlagShow(boolean flagShow) {
        this.flagShow = flagShow;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Filme getFilmeSel() {
        return filmeSel;
    }

    public void setFilmeSel(Filme filmeSel) {
        this.filmeSel = filmeSel;
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
