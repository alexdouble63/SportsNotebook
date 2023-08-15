package com.alexdouble.sportsnotebook.models;

import jakarta.persistence.*;

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
    private String descriptionDifficulty;

    @Column(name = "numberofrepetitions")
    private int numberOfRepetitions;

    @Column(name = "numberofsets")
    private int numberOfSets;

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
