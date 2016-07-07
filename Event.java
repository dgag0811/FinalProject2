package com.example.monikagarg.finalproject;

import java.sql.Time;

/**
 * Created by monikagarg on 6/26/2016.
 */

    public class Event {
        private String date,title,time,venue,description,attendees;
    public Event() {
    }
    public Event(String date, String title, String description,String venue, String attendees, String time) {
        this.date=date;
        this.title = title;
        this.time = time;
        this.venue = venue;
        this.description = description;
        this.attendees = attendees;
    }
    public String getDate()
    {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getVenue() {
        return venue;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getAttendees() {
        return attendees;
    }
    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time)
    {
        this.time = time;
    }

}
