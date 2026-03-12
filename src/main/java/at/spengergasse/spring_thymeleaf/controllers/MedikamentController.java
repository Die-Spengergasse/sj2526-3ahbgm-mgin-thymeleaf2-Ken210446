package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Medikament;
import at.spengergasse.spring_thymeleaf.entities.MedikamentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medikament")
public class MedikamentController {

    private final MedikamentRepository repository;

    public MedikamentController(MedikamentRepository repository) {
        this.repository = repository;
    }

    // Alle anzeigen
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("medikamente", repository.findAll());
        return "medlist";
    }

    // Formular anzeigen
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("medikament", new Medikament());
        return "add_medikament";
    }

    // Speichern
    @PostMapping("/add")
    public String save(@ModelAttribute Medikament medikament) {
        repository.save(medikament);
        return "redirect:/medikament/list";
    }

    // Löschen
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect:/medikament/list";
    }

    // Bearbeiten anzeigen
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("medikament", repository.findById(id).orElseThrow());
        return "edit_medikament";
    }

    // Update speichern
    @PostMapping("/update")
    public String update(@ModelAttribute Medikament medikament) {
        repository.save(medikament);
        return "redirect:/medikament/list";
    }
}