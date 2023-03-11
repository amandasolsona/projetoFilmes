package br.com.santandercoders.locadora.filmes.controller;

import br.com.santandercoders.locadora.filmes.dao.NoticiaDAO;
import br.com.santandercoders.locadora.filmes.model.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/noticia")
public class NoticiaController {

    @Autowired
    private NoticiaDAO noticiaDAO;

    @GetMapping
    public String listar(Model model) {
        List<Noticia> noticias = noticiaDAO.listarNoticias();
        model.addAttribute("noticias", noticias);
        return "noticia_listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Noticia noticia = noticiaDAO.buscarPorId(id);
        model.addAttribute("noticia", noticia);
        return "noticia_editar";
    }

    @PostMapping("/atualizar")
    public String atualizar(Noticia noticia) {
        noticiaDAO.editarNoticia(noticia);
        return "redirect:/noticia";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        noticiaDAO.removerNoticiaPorId(id);
        return "redirect:/noticia";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("noticia", new Noticia());
        return "noticia_nova";
    }

    @PostMapping("/adicionar")
    public String adicionar(Noticia noticia) {
        noticiaDAO.adicionarNoticia(noticia);
        return "redirect:/noticia";
    }

}
