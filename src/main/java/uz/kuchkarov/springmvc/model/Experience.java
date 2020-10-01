package uz.kuchkarov.springmvc.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "experience")
public class Experience {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String company;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean inJobNow;
    private String events;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Employer employer;

    public Experience() {
    }

    public Experience(Long id, String position, String company, String location, LocalDate startDate, LocalDate endDate, Boolean inJobNow, String events) {
        this.id = id;
        this.position = position;
        this.company = company;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.inJobNow = inJobNow;
        this.events = events;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
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
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
