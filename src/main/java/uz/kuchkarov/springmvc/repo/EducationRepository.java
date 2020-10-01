package uz.kuchkarov.springmvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kuchkarov.springmvc.model.Education;
import uz.kuchkarov.springmvc.model.Employer;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findAllByEmployer(Employer employer);
}
