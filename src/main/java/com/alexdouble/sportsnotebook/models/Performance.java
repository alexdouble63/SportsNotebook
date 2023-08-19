package com.alexdouble.sportsnotebook.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.Date;

@Entity
@Table (name = "performance")
public class Performance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dateperformance")
    private Date date;

    @Column(name = "countinperformance")
    @Min(value = 0, message = "Count should be greater than 0")
    private int countPerformance;

    @ManyToOne
    @JoinColumn(name = "sportsman_id", referencedColumnName = "id_sportsman")
    private Sportsman ownerSportsman;

    @ManyToOne
    @JoinColumn(name = "difficulty_id", referencedColumnName = "iddifficulty")
    private DifficultyExercise ownerDifficulty;

    public Performance() {
    }

    public Performance(Date date, int countPerformance) {
        this.date = date;
        this.countPerformance = countPerformance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCountPerformance() {
        return countPerformance;
    }

    public void setCountPerformance(int countPerformance) {
        this.countPerformance = countPerformance;
    }

    public Sportsman getOwnerSportsman() {
        return ownerSportsman;
    }

    public void setOwnerSportsman(Sportsman ownerSportsman) {
        this.ownerSportsman = ownerSportsman;
    }

    public DifficultyExercise getOwnerDifficulty() {
        return ownerDifficulty;
    }

    public void setOwnerDifficulty(DifficultyExercise ownerDifficulty) {
        this.ownerDifficulty = ownerDifficulty;
    }
}
