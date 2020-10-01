package uz.kuchkarov.springmvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kuchkarov.springmvc.model.Employer;
import uz.kuchkarov.springmvc.model.Experience;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findAllByEmployer(Employer employer);
}
