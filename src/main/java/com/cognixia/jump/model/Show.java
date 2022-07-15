package com.cognixia.jump.model;

import java.io.Serializable;

public class Show implements Serializable {

    private String show_name;
    private int num_of_episodes;
    private double show_rating;

    public Show(String show_name, int num_of_episodes, double show_rating) {
        this.show_name = show_name;
        this.num_of_episodes = num_of_episodes;
        this.show_rating = show_rating;
    }

    public String getShow_name() {
        return show_name;
    }

    public void setShow_name(String show_name) {
        this.show_name = show_name;
    }

    public int getNum_of_episodes() {
        return num_of_episodes;
    }

    public void setNum_of_episodes(int num_of_episodes) {
        this.num_of_episodes = num_of_episodes;
    }

    public double getShow_rating() {
        return show_rating;
    }

    public void setShow_rating(double show_rating) {
        this.show_rating = show_rating;
    }

    @Override
    public String toString() {
        return "Show [num_of_episodes=" + num_of_episodes + ", show_name=" + show_name + ", show_rating=" + show_rating
                + "]";
    }

}
