package com.alexdouble.sportsnotebook.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table (name = "difficultyexercise")
public class DifficultyExercise {

    @Id
    @Column (name = "iddifficulty")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDifficulty;

    @ManyToOne
    @JoinColumn(name="idexercise", referencedColumnName = "id")
    private Exercise ownerExercise;

    @Column(name = "descriptiondifficulty")
    @NotEmpty(message = "Step description should not be empty")
    private String descriptionDifficulty;

    @Column(name = "numberofrepetitions")
    @Min(value=0,message = "oal counts should be greater than 0")
    private int numberOfRepetitions;

    @Column(name = "numberofsets")
    @Min(value=0,message = "Goal sets should be greater than 0")
    private int numberOfSets;

    @OneToMany(mappedBy = "ownerDifficulty")
    List<Performance> performanceList;

    public DifficultyExercise() {
    }

    public DifficultyExercise(String descriptionDifficulty,
                              int numberOfRepetitions, int numberOfSets) {
        this.descriptionDifficulty = descriptionDifficulty;
        this.numberOfRepetitions = numberOfRepetitions;
        this.numberOfSets = numberOfSets;
    }

    public int getIdDifficulty() {
        return idDifficulty;
    }

    public String getDescriptionDifficulty() {
        return descriptionDifficulty;
    }

    public void setDescriptionDifficulty(String descriptionDifficulty) {
        this.descriptionDifficulty = descriptionDifficulty;
    }

    public int getNumberOfRepetitions() {
        return numberOfRepetitions;
    }

    public void setNumberOfRepetitions(int numberOfRepetitions) {
        this.numberOfRepetitions = numberOfRepetitions;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    public Exercise getOwnerExercise() {
        return ownerExercise;
    }

    public void setOwnerExercise(Exercise ownerExercise) {
        this.ownerExercise = ownerExercise;
    }
}
