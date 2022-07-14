package com.cognixia.jump.model;

import java.io.Serializable;

public class ShowsWatched implements Serializable {

    private int userId;
    private String show_name;
    private int episodes_watched;

    public ShowsWatched(int userId, String show_name, int episodes_watched) {
        this.userId = userId;
        this.show_name = show_name;
        this.episodes_watched = episodes_watched;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getShow_name() {
        return show_name;
    }

    public void setShow_name(String show_name) {
        this.show_name = show_name;
    }

    public int getEpisodes_watched() {
        return episodes_watched;
    }

    public void setEpisodes_watched(int episodes_watched) {
        this.episodes_watched = episodes_watched;
    }

    @Override
    public String toString() {
        return "ShowsWatched [episodes_watched=" + episodes_watched + ", show_name=" + show_name + ", userId=" + userId
                + "]";
    }

    

    

    
    
}
