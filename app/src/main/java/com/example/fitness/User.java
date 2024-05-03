package com.example.fitness;

public class User {
    private String username;
    private int steps;
    private int calories;

    public User(String username, int steps, int calories) {
        this.username = username;
        this.steps = steps;
        this.calories = calories;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}

