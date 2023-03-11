package br.com.santandercoders.locadora.filmes.controller;

import br.com.santandercoders.locadora.filmes.dao.FilmeDAO;
import br.com.santandercoders.locadora.filmes.dao.NoticiaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private FilmeDAO filmeDAO;
    @Autowired
    private NoticiaDAO noticiaDAO;

    @GetMapping
    public String paginaInicial(Model model) {
        model.addAttribute("filmes", filmeDAO.listarFilmes());
        model.addAttribute("noticias", noticiaDAO.listarNoticias());
        return "pagina_inicial";
    }

}
