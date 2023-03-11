package br.com.santandercoders.locadora.filmes.controller;

import br.com.santandercoders.locadora.filmes.dao.AtorDAO;
import br.com.santandercoders.locadora.filmes.model.Ator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    private AtorDAO atorDAO;

    @GetMapping
    public String listar(Model model) {
        List<Ator> atores = atorDAO.listarTodos();
        model.addAttribute("atores", atores);
        return "ator_listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Ator ator = atorDAO.buscarPorId(id);
        model.addAttribute("ator", ator);
        return "ator_editar";
    }

    @PostMapping("/atualizar")
    public String atualizar(Ator ator) {
        atorDAO.editarAtor(ator);
        return "redirect:/ator";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        atorDAO.remover(id);
        return "redirect:/ator";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("ator", new Ator());
        return "ator_novo";
    }

    @PostMapping("/adicionar")
    public String adicionar(Ator ator) {
        atorDAO.adicionarAtor(ator);
        return "redirect:/ator";
    }

}
