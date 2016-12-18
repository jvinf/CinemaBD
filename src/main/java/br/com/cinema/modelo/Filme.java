package br.com.cinema.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "filme")
public class Filme implements Serializable {

    private Integer id;
    private String nomeOriginal;
    private String nomeEmCartaz;
    private Date anoLancamento;
    private String nomeDiretor;
    private boolean emCartaz;
    private String sinopse;
    private String idioma;
    private boolean legendado;
    private Date dataEstreia;
    private Integer duracao;
    private String estudio;
    private Classificacao idClassificacao;
    private Genero idGenero;

    @Id
    @Column(name = "idfilme")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nomeoriginal")
    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    @Column(name = "nomeemcartaz")
    public String getNomeEmCartaz() {
        return nomeEmCartaz;
    }

    public void setNomeEmCartaz(String nomeEmCartaz) {
        this.nomeEmCartaz = nomeEmCartaz;
    }

    @Column(name = "anolancamento")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Date anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Column(name = "nomediretor")
    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    @Column(name = "emcartaz")
    public boolean isEmCartaz() {
        return emCartaz;
    }

    public void setEmCartaz(boolean emCartaz) {
        this.emCartaz = emCartaz;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isLegendado() {
        return legendado;
    }

    public void setLegendado(boolean legendado) {
        this.legendado = legendado;
    }

    @Column(name = "dataestreia")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(Date dataEstreia) {
        this.dataEstreia = dataEstreia;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @ManyToOne
    @JoinColumn(name = "idclassificacao")
    public Classificacao getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(Classificacao idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    @ManyToOne
    @JoinColumn(name = "idgenero")
    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

}
