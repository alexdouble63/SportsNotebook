package com.alexdouble.sportsnotebook.services;

import com.alexdouble.sportsnotebook.models.DifficultyExercise;
import com.alexdouble.sportsnotebook.models.Performance;
import com.alexdouble.sportsnotebook.models.Sportsman;
import com.alexdouble.sportsnotebook.repositories.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PerformanceService {
    private final PerformanceRepository performanceRepository;

    @Autowired
    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    @Transactional
    public void save(Performance newPerformance){
        performanceRepository.save(newPerformance);
    }

    public List<Performance> allPerformanceByDifficultyForSportsman(int idSportsman, int iddifficultyExercise){
        List<Performance> performanceList = performanceRepository.findAll().stream().filter(p->p.getOwnerSportsman().getId_sportsman()==idSportsman
                && p.getOwnerDifficulty().getIdDifficulty()==iddifficultyExercise).toList();
        return performanceList;
    }

    @Transactional
    public void delete(Performance performance){
        performanceRepository.delete(performance);
    }

    public Performance getPerformanceById(int id){
        return performanceRepository.findById(id).orElse(null);
    }
}
