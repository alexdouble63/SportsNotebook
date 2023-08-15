package com.alexdouble.sportsnotebook.models;

import jakarta.persistence.*;

@Entity
@Table(name="sportsman")
public class Sportsman {

    @Id
    @Column(name = "id_sportsman")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sportsman;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "height")
    private int height;
    @Column(name = "weight")
    private float weight;

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
