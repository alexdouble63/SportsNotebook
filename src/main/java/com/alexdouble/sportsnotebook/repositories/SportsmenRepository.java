package com.alexdouble.sportsnotebook.repositories;

import com.alexdouble.sportsnotebook.models.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsmenRepository extends JpaRepository<Sportsman, Integer> {
}
