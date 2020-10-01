package uz.kuchkarov.springmvc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import uz.kuchkarov.springmvc.exception.NotFoundException;
import uz.kuchkarov.springmvc.model.Employer;
import uz.kuchkarov.springmvc.repo.EmployerRepository;

import java.util.List;

@Service
public class EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public List<Employer> getAll() {
        return employerRepository.findAll();
    }

    public Employer getOne(Long id) {
        return employerRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Employer edit(Long id, Employer employer) {
            Employer fromDb = getOne(id);
            BeanUtils.copyProperties(employer, fromDb, "id");
            return employerRepository.save(fromDb);
    }

    public Employer save(Employer employer) {
        return employerRepository.save(employer);
    }

    public void delete(Long id) {
        Employer fromDb = getOne(id);
        employerRepository.delete(fromDb);
    }
}
