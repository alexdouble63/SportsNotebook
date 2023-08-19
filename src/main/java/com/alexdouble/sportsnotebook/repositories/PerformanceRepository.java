package com.alexdouble.sportsnotebook.repositories;

import com.alexdouble.sportsnotebook.models.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Integer> {
}
