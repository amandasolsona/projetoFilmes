package br.com.santandercoders.locadora.filmes.dao;

import br.com.santandercoders.locadora.filmes.model.Ator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AtorDAO {

    private static List<Ator> atores = new ArrayList<>();
    private static Long proximoId = Long.valueOf(1);

    public void adicionarAtor(Ator ator) {
        ator.setId(proximoId++);
        atores.add(ator);
    }

    public void editarAtor(Ator ator) {
        for (int i = 0; i < atores.size(); i++) {
            Ator a = atores.get(i);
            if (a.getId().equals(ator.getId())) {
                atores.set(i, ator);
                break;
            }
        }
    }

    public void remover(Long id) {
        atores.removeIf(ator -> ator.getId().equals(id));
    }

    public Ator buscarPorId(Long id) {
        return atores.stream()
                .filter(ator -> ator.getId().equals(id)).findFirst()
                .orElse(null);
    }

    public List<Ator> listarTodos() {
        return atores;
    }

}
