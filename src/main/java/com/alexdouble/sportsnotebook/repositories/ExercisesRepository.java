package com.alexdouble.sportsnotebook.repositories;

import com.alexdouble.sportsnotebook.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercisesRepository extends JpaRepository<Exercise,Integer> {
}
