package com.example.monikagarg.finalproject;

/**
 * Created by DELL on 6/27/2016.
 */
public class Timetable {

    private String course,type,day,faculty,venue,fromtime,totime;
    public Timetable()
    {

    }
    public Timetable(String course, String type, String faculty,String venue,String fromtime,String totime,String day)
    {
        this.course=course;
        this.type=type;
        this.venue=venue;
        this.faculty=faculty;
        this.fromtime= fromtime;
        this.totime=totime;
        this.day=day;

    }

    public String getFromtime() {
        return fromtime;
    }
    public void setFromtime(String fromtime) {
        this.fromtime = fromtime;
    }

    public String getTotime() {
        return totime;
    }
    public void setTotime(String totime) {
        this.totime = totime;
    }

    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getVenue() { return venue; }
    public void setVenue(String venue) {
        this.venue = venue;
    }


}