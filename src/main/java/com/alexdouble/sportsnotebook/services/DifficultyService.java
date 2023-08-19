package com.alexdouble.sportsnotebook.services;

import com.alexdouble.sportsnotebook.models.DifficultyExercise;
import com.alexdouble.sportsnotebook.models.Exercise;
import com.alexdouble.sportsnotebook.repositories.DifficultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DifficultyService {
    private final DifficultyRepository difficultyRepository;

    @Autowired
    public DifficultyService(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    @Transactional
    public void deleteDifficultyById(int idDifficalty){
        difficultyRepository.deleteById(idDifficalty);
    }

    @Transactional
    public void save(DifficultyExercise difficultyExercise){
        difficultyRepository.save(difficultyExercise);
    }

    public List<DifficultyExercise> getAllDifficultyForExercise(Exercise exercise){
        return difficultyRepository.findAll().stream().filter(p->p.getOwnerExercise()==exercise).toList();

    }

    public DifficultyExercise getDifficultyById(int idDiddicalty){
        return difficultyRepository.findById(idDiddicalty).orElse(null);
    }

}
