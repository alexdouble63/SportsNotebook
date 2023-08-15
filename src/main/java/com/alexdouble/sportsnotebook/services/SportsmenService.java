package com.alexdouble.sportsnotebook.services;

import com.alexdouble.sportsnotebook.models.Sportsman;
import com.alexdouble.sportsnotebook.repositories.SportsmenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly=true)
public class SportsmenService {

    private final SportsmenRepository sportsmenRepository;

    @Autowired
    public SportsmenService(SportsmenRepository sportsmenRepository) {
        this.sportsmenRepository = sportsmenRepository;
    }

    public List<Sportsman> findAll(){
        return sportsmenRepository.findAll();
    }
    public Sportsman findOne(int id){
        Optional<Sportsman> foundSportsman = sportsmenRepository.findById(id);
        return foundSportsman.orElse(null);
    }

    @Transactional
    public void save(Sportsman sportsman){
        sportsmenRepository.save(sportsman);
    }

    @Transactional
    public void update(int id, Sportsman updateSportsman){
        updateSportsman.setId_sportsman(id);
        sportsmenRepository.save(updateSportsman);
    }

    @Transactional
    public void delete(int id){
        sportsmenRepository.deleteById(id);
    }
}
