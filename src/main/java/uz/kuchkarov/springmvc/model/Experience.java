package uz.kuchkarov.springmvc.model;

import java.time.LocalDate;

public class Experience {

    private Long id;
    private String position;
    private String Company;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean inJobNow;
    private String events;

    public Experience() {
    }

    public Experience(Long id, String position, String company, String location, LocalDate startDate, LocalDate endDate, Boolean inJobNow, String events) {
        this.id = id;
        this.position = position;
        Company = company;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.inJobNow = inJobNow;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getInJobNow() {
        return inJobNow;
    }

    public void setInJobNow(Boolean inJobNow) {
        this.inJobNow = inJobNow;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }
}
