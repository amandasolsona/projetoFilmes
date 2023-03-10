package br.com.santandercoders.locadora.filmes.dao;

import br.com.santandercoders.locadora.filmes.model.Noticia;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoticiaDAO {

    private static List<Noticia> noticias = new ArrayList<>();
    private static Long proximoId = Long.valueOf(1);

    public void adicionarNoticia(Noticia noticia) {
        noticia.setId(proximoId++);
        noticias.add(noticia);
    }

    public void editarNoticia(Noticia noticia) {
        for (int i = 0; i < noticias.size(); i++) {
            Noticia n = noticias.get(i);
            if (n.getId().equals(noticia.getId())) {
                noticias.set(i, noticia);
                break;
            }
        }
    }

    public void removerNoticiaPorId(Long id) {
        noticias.removeIf(noticia -> noticia.getId().equals(id));
    }

    public List<Noticia> listarNoticias() {
        return noticias;
    }

}
