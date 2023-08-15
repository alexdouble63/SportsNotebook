package com.alexdouble.sportsnotebook.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="exercise")
public class Exercise {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_exercise;

    public Exercise() {
    }

    @Column(name = "name")
    private String nameExercise;

    @Column(name = "description")
    private String descriptionExercise;

    @OneToMany(mappedBy = "ownerExercise")
    private List<DifficultyExercise> difficultyExerciseList;


    public Exercise(String nameExercise, String descriptionExercise) {
        this.nameExercise = nameExercise;
        this.descriptionExercise = descriptionExercise;
    }

    public int getId_exercise() {
        return id_exercise;
    }

    public void setId_exercise(int id_exercise) {
        this.id_exercise = id_exercise;
    }

    public String getNameExercise() {
        return nameExercise;
    }

    public void setNameExercise(String nameExercise) {
        this.nameExercise = nameExercise;
    }

    public String getDescriptionExercise() {
        return descriptionExercise;
    }

    public void setDescriptionExercise(String descriptionExercise) {
        this.descriptionExercise = descriptionExercise;
    }

    public List<DifficultyExercise> getDifficultyExerciseList() {
        return difficultyExerciseList;
    }

    public void setDifficultyExerciseList(List<DifficultyExercise> difficultyExerciseList) {
        this.difficultyExerciseList = difficultyExerciseList;
    }
}
