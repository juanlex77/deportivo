package com.deportivo.app.controller;

import com.deportivo.app.model.Club;
import com.deportivo.app.model.Entrenador;
import com.deportivo.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clubes")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private EntrenadorRepository entrenadorRepository;
    @Autowired
    private JugadorRepository jugadorRepository;
    @Autowired
    private AsociacionRepository asociacionRepository;
    @Autowired
    private CompeticionRepository competicionRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        return "clubes/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("club", new Club());
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("jugadores", jugadorRepository.findAll());
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("competiciones", competicionRepository.findAll());
        return "clubes/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Club club) {
        
        if (club.getEntrenador() != null && club.getEntrenador().getId() != null) {
            Entrenador entrenador = entrenadorRepository.findById(club.getEntrenador().getId()).orElse(null);
            club.setEntrenador(entrenador);
        }
        
        clubRepository.save(club);
        return "redirect:/clubes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Club club = clubRepository.findById(id).orElse(null);
        model.addAttribute("club", club);
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("jugadores", jugadorRepository.findAll());
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("competiciones", competicionRepository.findAll());
        return "clubes/editar";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable String id, @ModelAttribute Club club) {
        club.setId(id);
        clubRepository.save(club);
        return "redirect:/clubes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        clubRepository.deleteById(id);
        return "redirect:/clubes";
    }
}