package com.alexdouble.sportsnotebook.controllers;

import com.alexdouble.sportsnotebook.models.Sportsman;
import com.alexdouble.sportsnotebook.services.SportsmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sportsmen")
public class SportsmenController {

    private final SportsmenService sportsmenService;

    @Autowired
    public SportsmenController(SportsmenService sportsmenService) {
        this.sportsmenService = sportsmenService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("sportsmen", sportsmenService.findAll());
        return "/sportsmen/sportsmen";
    }

    @GetMapping("/{id}")
    public String getSportsmanById(@PathVariable int id, Model model){
        model.addAttribute("sportsman",sportsmenService.findOne(id));
        return "/sportsmen/sportsman";
    }

    @GetMapping("/newSportsman")
    public String inputNewSportsman(Model model){
        model.addAttribute("sportsman",new Sportsman());
        return "/sportsmen/newSportsman";
    }

    @PostMapping
    public String addNewSportsman(@ModelAttribute Sportsman sportsman){
        sportsmenService.save(sportsman);
        return "redirect:/sportsmen";
    }

    @DeleteMapping("/{id}")
    public String deleteSportsman(@PathVariable int id){
        sportsmenService.delete(id);
        return "redirect:/sportsmen";
    }

    @GetMapping("editSportsman/{id}")
    public String editSportsmanById(@PathVariable int id, Model model){
        model.addAttribute("sportsman",sportsmenService.findOne(id));
        return "/sportsmen/editSportsman";
    }

    @PutMapping("/{id}")
    public String saveEditedSportsman(@PathVariable int id, @ModelAttribute Sportsman sportsman){
        sportsmenService.update(id,sportsman);
        return "redirect:/sportsmen/"+sportsman.getId_sportsman();

    }
}
