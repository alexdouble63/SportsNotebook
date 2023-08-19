package com.alexdouble.sportsnotebook.controllers;

import com.alexdouble.sportsnotebook.models.DifficultyExercise;
import com.alexdouble.sportsnotebook.models.Exercise;
import com.alexdouble.sportsnotebook.repositories.DifficultyRepository;
import com.alexdouble.sportsnotebook.services.DifficultyService;
import com.alexdouble.sportsnotebook.services.ExercisesService;
import jakarta.validation.Valid;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/difficulty")
public class DifficultyController {


    private final ExercisesService exercisesService;
    private final DifficultyService difficultyService;

    @Autowired
    public DifficultyController(DifficultyService difficultyService,ExercisesService exercisesService) {
        this.difficultyService = difficultyService;
        this.exercisesService = exercisesService;
    }

    @DeleteMapping("/delete/{id}/{iddiff}")
    public String deleteDifficultyById(@PathVariable int id,
                                       @PathVariable int iddiff){
        difficultyService.deleteDifficultyById(iddiff);
        return "redirect:/exercises/"+id;
    }

    @PostMapping("/{idExercise}")
    public String addDifficultForExercise(@PathVariable int idExercise,
                                          @ModelAttribute @Valid DifficultyExercise difficultyExercise,
                                          BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/exercises/"+idExercise;
        }
        difficultyExercise.setOwnerExercise(exercisesService.findOne(idExercise));
        Exercise exercise = exercisesService.findOne(idExercise);
        difficultyExercise.setOwnerExercise(exercise);
        difficultyService.save(difficultyExercise);
        return "redirect:/exercises/"+idExercise;

    }
}
