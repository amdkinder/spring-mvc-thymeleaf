package uz.kuchkarov.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private GraduationDegree graduationDegree;
    private String graduationYear;
    private String location;
    private String specialization;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    private Employer employer;

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Education() {
    }

    public Education(Long id, String place, GraduationDegree graduationDegree, String graduationYear, String location) {
        this.id = id;
        this.place = place;
        this.graduationDegree = graduationDegree;
        this.graduationYear = graduationYear;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public GraduationDegree getGraduationDegree() {
        return graduationDegree;
    }

    public void setGraduationDegree(GraduationDegree graduationDegree) {
        this.graduationDegree = graduationDegree;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", graduationDegree=" + graduationDegree +
                ", graduationYear='" + graduationYear + '\'' +
                ", location='" + location + '\'' +
                ", specialization='" + specialization + '\'' +
                ", employer=" + employer +
                '}';
    }
}
