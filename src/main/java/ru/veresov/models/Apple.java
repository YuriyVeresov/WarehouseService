package ru.veresov.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Apple {
    private int id;
    @NotEmpty(message = "Field must not be empty")
    @Min(value = 0, message = "Weight should not be 0")
    private double weight;
    @NotEmpty(message = "Field must not be empty")
    private Colors color;
    @NotEmpty(message = "Field must not be empty")
    private String grade;
    @NotEmpty(message = "Field must not be empty")
    private boolean sour;

    public Apple(int id, double weight, Colors color, String grade, boolean sour) {
        this.id = id;
        this.weight = weight;
        this.color = color;
        this.grade = grade;
        this.sour = sour;
    }

    public Apple() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
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

    @Override
    public String toString() {
        String yesOrNo;
        if (sour) yesOrNo = "NO";
        else yesOrNo = "YES";

        return "Apple " +
                "id= " + id +
                " , weight: " + weight +
                " , color: " + color +
                " , grade: " + grade +
                " , sour: " + yesOrNo;
    }
}