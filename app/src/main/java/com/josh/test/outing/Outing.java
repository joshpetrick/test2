package com.josh.test.outing;

import com.josh.test.course.GolfCourse;

/**
 * Created by Josh on 7/3/2016.
 */
public class Outing {

    private String name;
    private String date;
    private GolfCourse course;

    public Outing(String name,String date,GolfCourse course)
    {
        setName(name);
        setDate(date);
        setCourse(course);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public GolfCourse getCourse() {
        return course;
    }

    public void setCourse(GolfCourse course) {
        this.course = course;
    }
}
