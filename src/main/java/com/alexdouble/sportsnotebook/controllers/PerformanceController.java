package com.alexdouble.sportsnotebook.controllers;

import com.alexdouble.sportsnotebook.models.DifficultyExercise;
import com.alexdouble.sportsnotebook.models.Performance;
import com.alexdouble.sportsnotebook.repositories.PerformanceRepository;
import com.alexdouble.sportsnotebook.services.DifficultyService;
import com.alexdouble.sportsnotebook.services.ExercisesService;
import com.alexdouble.sportsnotebook.services.PerformanceService;
import com.alexdouble.sportsnotebook.services.SportsmenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/performance")
public class PerformanceController {

    private final PerformanceService performanceService;
    private final DifficultyService difficultyService;
    private final SportsmenService sportsmenService;
    private final ExercisesService exercisesService;

    @Autowired
    public PerformanceController(PerformanceService performanceService,
                                 DifficultyService difficultyService,
                                 SportsmenService sportsmenService,
                                 ExercisesService exercisesService) {
        this.performanceService = performanceService;
        this.difficultyService = difficultyService;
        this.sportsmenService = sportsmenService;
        this.exercisesService = exercisesService;
    }





    /*@PostMapping ("/{idSportsman}")
    public String addNewPerformance(@PathVariable int idSportsman,
                                    @ModelAttribute Performance newPerformance){
        newPerformance.setOwnerSportsman(sportsmenService.findOne(idSportsman));
        //newPerformance.setOwnerDifficulty(null);
        newPerformance.setDate(new Date(123123123));
        performanceService.save(newPerformance);
        return "redirect:/sportsman/"+idSportsman;
    }*/

    @GetMapping
    public String showAllPerformanceForSportsman (@RequestParam int idSportsman,
                                                  @RequestParam int idExercise, Model model){
        model.addAttribute("sportsman", sportsmenService.findOne(idSportsman));

        List<DifficultyExercise> difficultyExerciseList = difficultyService.
                getAllDifficultyForExercise(exercisesService.findOne(idExercise));
        model.addAttribute("difficulty",difficultyExerciseList);
        return "/performance/performance";
    }

    @GetMapping("/allForDifficalty")
    public String allDifficaltyForSportsman(@RequestParam int idSportsman,
                                            @RequestParam int idDiff, Model model){
        model.addAttribute("idSportsman", sportsmenService.findOne(idSportsman));
        model.addAttribute("idDifficalty",difficultyService.getDifficultyById(idDiff));
        model.addAttribute("newPerformance", new Performance());
        model.addAttribute("listPerformance",performanceService.allPerformanceByDifficultyForSportsman(idSportsman,idDiff));
        return "/performance/allForDifficalty";

    }

    @PostMapping("/addNewResult")
    public String addNewResult(@RequestParam int idSportsman,
                               @RequestParam int idDifficalty,
                               @ModelAttribute @Valid Performance newPerformance,
                               BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "redirect:/performance/allForDifficalty";//?idSportsman="+idSportsman+"&idDiff="+idDifficalty;
        }

        newPerformance.setOwnerSportsman(sportsmenService.findOne(idSportsman));
        newPerformance.setOwnerDifficulty(difficultyService.getDifficultyById(idDifficalty));
        newPerformance.setDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        performanceService.save(newPerformance);
        return "redirect:/performance/allForDifficalty?idSportsman="+idSportsman+"&idDiff="+idDifficalty;
    }

    @DeleteMapping("/deleteResult")
    public String deleteResult (@RequestParam int idSportsman,
                                @RequestParam int idDifficalty,
                                @RequestParam int idPerformance){

        performanceService.delete(performanceService.getPerformanceById(idPerformance));

        return "redirect:/performance/allForDifficalty?idSportsman="+idSportsman+"&idDiff="+idDifficalty;

    }
}
