package com.alexdouble.sportsnotebook.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name="sportsman")
public class Sportsman {

    @Id
    @Column(name = "id_sportsman")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sportsman;
    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min=3, max=50, message = "Name should be between 3 and 50 characters")
    private String name;
    @Column(name = "age")
    @Min(value=0,message = "Age should be greater than 0")
    private int age;
    @Column(name = "height")
    @Min(value=0,message = "Height should be greater than 0")
    private int height;
    @Column(name = "weight")
    @Min(value=0,message = "Weight should be greater than 0")
    private float weight;

    @OneToMany (mappedBy = "ownerSportsman")
    private List<Performance> performanceList;


    public Sportsman() {
    }

    public Sportsman(int id_sportsman, String name, int age, int height, float weight) {
        this.id_sportsman = id_sportsman;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }


    public int getId_sportsman() {
        return id_sportsman;
    }

    public void setId_sportsman(int id_sportsman) {
        this.id_sportsman = id_sportsman;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
