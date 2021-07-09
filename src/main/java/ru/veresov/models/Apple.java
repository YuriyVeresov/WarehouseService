package ru.veresov.models;

public class Apple {
    private int id;
    private double weight;
    String color;
    private String grade;
    private boolean sour;


    public Apple(int id, double weight, String color, String grade, boolean sour) {
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