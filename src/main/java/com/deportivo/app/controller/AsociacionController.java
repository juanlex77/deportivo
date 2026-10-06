package com.deportivo.app.controller;

import com.deportivo.app.model.Asociacion;
import com.deportivo.app.repository.AsociacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asociaciones")
public class AsociacionController {

    @Autowired
    private AsociacionRepository asociacionRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        return "asociaciones/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "asociaciones/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Asociacion asociacion) {
        asociacionRepository.save(asociacion);
        return "redirect:/asociaciones";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Asociacion asociacion = asociacionRepository.findById(id).orElse(null);
        model.addAttribute("asociacion", asociacion);
        return "asociaciones/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable String id, @ModelAttribute Asociacion asociacion) {
        asociacion.setId(id);
        asociacionRepository.save(asociacion);
        return "redirect:/asociaciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        asociacionRepository.deleteById(id);
        return "redirect:/asociaciones";
    }
}