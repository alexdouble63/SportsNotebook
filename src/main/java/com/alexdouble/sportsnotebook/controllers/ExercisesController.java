package com.alexdouble.sportsnotebook.controllers;

import com.alexdouble.sportsnotebook.models.DifficultyExercise;
import com.alexdouble.sportsnotebook.models.Exercise;
import com.alexdouble.sportsnotebook.services.ExercisesService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exercises")
public class ExercisesController {

    private final ExercisesService exercisesService;

    @Autowired
    public ExercisesController(ExercisesService exercisesService) {
        this.exercisesService = exercisesService;
    }

    @GetMapping
    public String showAllExercises(Model model){
        model.addAttribute("exercises", exercisesService.findAll());
        return "/exercises/exercises";
    }

    @GetMapping("/{id}")
    public String getExerciseById(@PathVariable int id, Model model){
        List<DifficultyExercise> difficultyExerciseList = exercisesService.getDifficultyListByExerciseId(id);
        model.addAttribute("exercise", exercisesService.findOne(id));
        model.addAttribute("difficults", difficultyExerciseList);
        model.addAttribute("newDiffcult", new DifficultyExercise());
        return "/exercises/exercise";
    }

    @GetMapping("/newExercise")
    public String inputNewExercise(Model model){
        model.addAttribute("exercise",new Exercise());
        return "/exercises/newExercise";
    }

    @PostMapping
    public String addNewExercise(@ModelAttribute @Valid Exercise exercise,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/exercises/newExercise";
        }
        exercisesService.save(exercise);
        return "redirect:/exercises";
    }

    @DeleteMapping("/{id}")
    public String deleteExercise(@PathVariable int id){
        exercisesService.delete(id);
        return "redirect:/exercises";
    }

    @GetMapping("editExercise/{id}")
    public String editExerciseById(@PathVariable int id, Model model){
        model.addAttribute("exercise",exercisesService.findOne(id));
        return "/exercises/editExercise";
    }

    @PutMapping("/{id}")
    public String saveEditedExercise(@PathVariable int id, @ModelAttribute @Valid Exercise exercise,
                                     BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/exercises/editExercise";
        }
        exercisesService.update(id,exercise);
        return "redirect:/exercises/"+exercise.getId_exercise();

    }

}
