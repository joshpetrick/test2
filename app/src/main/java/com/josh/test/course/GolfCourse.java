package com.josh.test.course;

/**
 * Created by Josh on 7/2/2016.
 */
public class GolfCourse {
    private String name;
    private String location;
    private String locale;

    public GolfCourse(String name, String location, String locale)
    {
        setName(name);
        setLocation(location);
        setLocale(locale);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
