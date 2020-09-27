package uz.kuchkarov.springmvc.service;

import org.springframework.stereotype.Service;
import uz.kuchkarov.springmvc.model.Employer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerService {

    private Long counter = 0L;
    private final List<Employer> employers = new ArrayList<>();

    {
        employers.add(new Employer(++counter, "Tom Jones", LocalDate.now(), "+99896265656", "tom@mail.com", "I am developer", "San Fransisco"));
        employers.add(new Employer(++counter, "Josh Long", LocalDate.now(), "+99892342353", "josh@mail.com", "I am system admin", "New york"));
        employers.add(new Employer(++counter, "George Maks", LocalDate.now(), "+99895656566", "george@mail.com", "I am simple worker", "Los Angelos"));
        employers.add(new Employer(++counter, "Mike Tayson", LocalDate.now(), "+99895562142", "mike@mail.com", "I am boxer", "Manhattan"));
    }

    public List<Employer> getAll() {
        return employers;
    }

    public Employer getOne(Long id) {
        return employers
                .stream()
                .filter(employer -> employer.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Employer save(Employer employer) {
        employer.setId(++counter);
        employers.add(employer);
        return employer;
    }

    public Employer edit(Long id, Employer employer){
        Employer fromDb = getOne(id);
        int index = employers.indexOf(fromDb);
        employer.setId(fromDb.getId());
        employers.set(index, employer);
        return employer;
    }

    public void delete(Long id) {
        Employer fromDb = getOne(id);
        employers.remove(fromDb);
    }
}
