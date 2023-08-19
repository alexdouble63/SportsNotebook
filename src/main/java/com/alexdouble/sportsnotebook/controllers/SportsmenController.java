package com.alexdouble.sportsnotebook.controllers;

import com.alexdouble.sportsnotebook.models.Performance;
import com.alexdouble.sportsnotebook.models.Sportsman;
import com.alexdouble.sportsnotebook.services.ExercisesService;
import com.alexdouble.sportsnotebook.services.SportsmenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sportsmen")
public class SportsmenController {

    private final SportsmenService sportsmenService;
    private final ExercisesService exercisesService;

    @Autowired
    public SportsmenController(SportsmenService sportsmenService, ExercisesService exercisesService) {
        this.sportsmenService = sportsmenService;
        this.exercisesService = exercisesService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("sportsmen", sportsmenService.findAll());
        return "/sportsmen/sportsmen";
    }

    @GetMapping("/{id}")
    public String getSportsmanById(@PathVariable int id, Model model){
        model.addAttribute("sportsman",sportsmenService.findOne(id));
        //model.addAttribute("newPerformance", new Performance());
        model.addAttribute("listExercises",exercisesService.findAll());
        return "/sportsmen/sportsman";
    }

    @GetMapping("/newSportsman")
    public String inputNewSportsmperformancean(Model model){
        model.addAttribute("sportsman",new Sportsman());
        return "/sportsmen/newSportsman";
    }

    @PostMapping
    public String addNewSportsman(@ModelAttribute @Valid Sportsman sportsman,
                                  BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/sportsmen/newSportsman";
        }
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
    public String saveEditedSportsman(@PathVariable int id, @ModelAttribute @Valid Sportsman sportsman,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/sportsmen/editSportsman";
        }
        sportsmenService.update(id,sportsman);
        return "redirect:/sportsmen/"+sportsman.getId_sportsman();

    }
}
