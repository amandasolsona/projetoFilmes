package br.com.santandercoders.locadora.filmes.model;

import java.util.ArrayList;
import java.util.List;

public class Filme {

    private Long id;
    private String titulo;
    private String genero;
    private Integer duracao;
    private String sinopse;
    private Double imdb;
    private String imagem;
    private Integer qteLike;
    private Integer qteDeslike;
    private List<Ator> atores = new ArrayList<>();
    private List<String> comentarios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Double getImdb() {
        return imdb;
    }

    public void setImdb(Double imdb) {
        this.imdb = imdb;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getQteLike() {
        return qteLike;
    }
    public void addLike() {
        qteLike++;
    }

    public Integer getQteDeslike() {
        return qteDeslike;
    }
    public void addDeslike() {
        qteDeslike++;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public void addComentario(String comentario) {
        comentarios.add(comentario);
    }

}
