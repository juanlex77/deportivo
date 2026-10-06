package com.deportivo.app.controller;

import com.deportivo.app.model.Jugador;
import com.deportivo.app.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorRepository jugadorRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "jugadores/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "jugadores/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Jugador jugador = jugadorRepository.findById(id).orElse(null);
        model.addAttribute("jugador", jugador);
        return "jugadores/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable String id, @ModelAttribute Jugador jugador) {
        jugador.setId(id);
        jugadorRepository.save(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        jugadorRepository.deleteById(id);
        return "redirect:/jugadores";
    }
}