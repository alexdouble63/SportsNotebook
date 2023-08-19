package com.alexdouble.sportsnotebook.services;


import com.alexdouble.sportsnotebook.models.DifficultyExercise;
import com.alexdouble.sportsnotebook.models.Exercise;
import com.alexdouble.sportsnotebook.models.Sportsman;
import com.alexdouble.sportsnotebook.repositories.DifficultyRepository;
import com.alexdouble.sportsnotebook.repositories.ExercisesRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ExercisesService {

    private final ExercisesRepository exercisesRepository;

    @Autowired
    public ExercisesService(ExercisesRepository exercisesRepository){//, DifficultyRepository difficultyRepository) {
        this.exercisesRepository = exercisesRepository;
        //this.difficultyRepository = difficultyRepository;
    }

    public List<Exercise> findAll(){
        return exercisesRepository.findAll();
    }
    public Exercise findOne(int id){
        Optional<Exercise> foundExercise = exercisesRepository.findById(id);
        return foundExercise.orElse(null);
    }

    @Transactional
    public void save(Exercise exercise){
        exercisesRepository.save(exercise);
    }

    @Transactional
    public void update(int id, Exercise updateExercise){
        updateExercise.setId_exercise(id);
        exercisesRepository.save(updateExercise);
    }

    @Transactional
    public void delete(int id){
        exercisesRepository.deleteById(id);
    }

    public List<DifficultyExercise> getDifficultyListByExerciseId(int idExercise){
        Optional<Exercise> exercise = exercisesRepository.findById(idExercise);
        if (exercise.isPresent()){
            return exercise.get().getDifficultyExerciseList();
        }else{
            return Collections.emptyList();
        }
    }

}
