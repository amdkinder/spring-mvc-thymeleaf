package uz.kuchkarov.springmvc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import uz.kuchkarov.springmvc.exception.NotFoundException;
import uz.kuchkarov.springmvc.model.Education;
import uz.kuchkarov.springmvc.model.Employer;
import uz.kuchkarov.springmvc.repo.EducationRepository;
import uz.kuchkarov.springmvc.repo.EmployerRepository;

import java.util.List;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<Education> getByEmployer(Employer employer) {
        return educationRepository.findAllByEmployer(employer);
    }

    public Education getOne(Long id) {
        return educationRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void save(Education education) {
        educationRepository.save(education);
    }

    public Education edit(Long id, Education education) {
        Education fromDb = getOne(id);
        BeanUtils.copyProperties(education, fromDb, "id", "employer");
        return educationRepository.save(fromDb);
    }

    public void delete(Long id) {
        Education fromDb = getOne(id);
        educationRepository.delete(fromDb);
    }
}
