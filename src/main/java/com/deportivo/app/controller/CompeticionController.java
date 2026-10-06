package com.deportivo.app.controller;

import com.deportivo.app.model.Competicion;
import com.deportivo.app.repository.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/competiciones")
public class CompeticionController {

    @Autowired
    private CompeticionRepository competicionRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("competiciones", competicionRepository.findAll());
        return "competiciones/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("competicion", new Competicion());
        return "competiciones/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Competicion competicion) {
        competicionRepository.save(competicion);
        return "redirect:/competiciones";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Competicion competicion = competicionRepository.findById(id).orElse(null);
        model.addAttribute("competicion", competicion);
        return "competiciones/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable String id, @ModelAttribute Competicion competicion) {
        competicion.setId(id);
        competicionRepository.save(competicion);
        return "redirect:/competiciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        competicionRepository.deleteById(id);
        return "redirect:/competiciones";
    }
}