package br.com.santandercoders.locadora.filmes.dao;

import br.com.santandercoders.locadora.filmes.model.Filme;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class FilmeDAO {

    private static List<Filme> filmes = new ArrayList<>();
    private static List<Filme> filmesFavoritos = new ArrayList<>();
    private static Long proximoId = Long.valueOf(1);

    public void adicionarFilme(Filme filme) {
        filme.setId(proximoId++);
        filmes.add(filme);
    }

    public void editarFilme(Filme filme) {
        for (int i = 0; i < filmes.size(); i++) {
            Filme f = filmes.get(i);
            if(f.getId().equals(filme.getId())) {
                filmes.set(i, filme);
                break;
            }
        }
    }

    public Filme buscarPorId(Long id) {
        return filmes.stream()
                .filter(f -> f.getId().equals(id)).findFirst()
                .orElse(null);
    }

    public List<Filme> listarFilmes() {
        return filmes;
    }

    public void removerFilmePorId(Long id) {
        filmes.removeIf(filme -> filme.getId().equals(id));
    }

    public void darLike(Long id) {
        Filme filme = filmes.stream()
                .filter(f -> f.getId().equals(id)).findFirst()
                .get();
        filme.addLike();
    }

    public void darDeslike(Long id) {
        Filme filme = filmes.stream()
                .filter(f -> f.getId().equals(id)).findFirst()
                .get();
        filme.addDeslike();
    }

    public List<Filme> listarFilmesPorGenero(String genero) {
        return filmes.stream()
                .filter(filme -> filme.getGenero().equals(genero))
                .collect(Collectors.toList());
    }

    public void salvarFilmeFavorito(Long id) {
        Filme filme = filmes.stream().filter(f -> f.getId().equals(id)).findFirst().get();
        filmesFavoritos.add(filme);
    }

    public void adicionarComentariosFilme(Long id, String comentario) {
        Filme filme = filmes.stream().filter(f -> f.getId().equals(id)).findFirst().get();
        filme.addComentario(comentario);
    }

    public List<Filme> listarFilmesPorMaisLikes() {
        return filmes.stream()
                .sorted(Comparator.comparingInt(filme -> filme.getQteLike()))
                .collect(Collectors.toList());
    }

}
