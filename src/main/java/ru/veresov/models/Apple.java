package ru.veresov.models;

import javax.persistence.*;

@Entity
@Table(name = "apple")
public class Apple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Integer id;
    @Column(name = "weight", nullable = false)
    private double weight;
    @Column(name = "color", nullable = false)
    String color;
    @Column(name = "grade", nullable = false, unique = true)
    private String grade;
    @Column(name = "sour", nullable = false)
    private boolean sour;


    public Apple(double weight, String color, String grade, boolean sour) {
        this.weight = weight;
        this.color = color;
        this.grade = grade;
        this.sour = sour;
    }

    public Apple() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isSour() {
        return sour;
    }

    public void setSour(boolean sour) {
        this.sour = sour;
    }

}
