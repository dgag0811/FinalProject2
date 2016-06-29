package com.example.monikagarg.finalproject;

import java.sql.Time;

/**
 * Created by monikagarg on 6/26/2016.
 */

public class Event {
    private String title,description,venue,attendees,time;
    private int image;


    public Event() {
    }

    public Event(String title, String description,String venue, String attendees, String time, int image) {
        this.title = title;
        this.time = time;
        this.venue = venue;
        this.description = description;
        this.attendees = attendees;
        this.image= image;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
