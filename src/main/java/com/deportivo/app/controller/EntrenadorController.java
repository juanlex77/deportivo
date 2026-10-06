package com.deportivo.app.controller;

import com.deportivo.app.model.Entrenador;
import com.deportivo.app.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        return "entrenadores/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        return "entrenadores/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Entrenador entrenador) {
        entrenadorRepository.save(entrenador);
        return "redirect:/entrenadores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Entrenador entrenador = entrenadorRepository.findById(id).orElse(null);
        model.addAttribute("entrenador", entrenador);
        return "entrenadores/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable String id, @ModelAttribute Entrenador entrenador) {
        entrenador.setId(id);
        entrenadorRepository.save(entrenador);
        return "redirect:/entrenadores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        entrenadorRepository.deleteById(id);
        return "redirect:/entrenadores";
    }
}