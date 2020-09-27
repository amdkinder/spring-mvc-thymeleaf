package uz.kuchkarov.springmvc.model;

public class Education {

    private Long id;
    private String place;
    private GraduationDegree graduationDegree;
    private String graduationYear;
    private String location;

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
}