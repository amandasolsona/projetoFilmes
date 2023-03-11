package br.com.santandercoders.locadora.filmes.controller;

import br.com.santandercoders.locadora.filmes.dao.FilmeDAO;
import br.com.santandercoders.locadora.filmes.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeDAO filmeDAO;

    @GetMapping
    public String listar(Model model) {
        List<Filme> filmes = filmeDAO.listarFilmes();
        model.addAttribute("filmes", filmes);
        return "filme_listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Filme filme = filmeDAO.buscarPorId(id);
        model.addAttribute("filme", filme);
        return "filme_editar";
    }

    @PostMapping("/atualizar")
    public String atualizar(Filme filme) {
        filmeDAO.editarFilme(filme);
        return "redirect:/filme";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("filme", new Filme());
        return "filme_novo";
    }

    @PostMapping("/adicionar")
    public String adicionar(Filme filme) {
        filmeDAO.adicionarFilme(filme);
        return "redirect:/filme";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        filmeDAO.removerFilmePorId(id);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable Long id) {
        filmeDAO.darLike(id);
        return "redirect:/";
    }

    @GetMapping("/deslike/{id}")
    public String deslike(@PathVariable Long id) {
        filmeDAO.darDeslike(id);
        return "redirect:/";
    }

    @GetMapping("/genero")
    public String listarPorGenero(Model model, String genero) {
        List<Filme> filmes = filmeDAO.listarFilmesPorGenero(genero);
        model.addAttribute("filmes", filmes);
        return "filmes_por_genero";
    }

    @GetMapping("favorito/{id}")
    public String favoritar(@PathVariable Long id) {
        filmeDAO.salvarFilmeFavorito(id);
        return "redirect:/";
    }

    @GetMapping("/mais-likes")
    public String listarPorMaisLikes(Model model) {
        List<Filme> filmesMaisLikes = filmeDAO.listarFilmesPorMaisLikes();
        model.addAttribute("filmes", filmesMaisLikes);
        return "filmes_mais_likes";
    }

}
