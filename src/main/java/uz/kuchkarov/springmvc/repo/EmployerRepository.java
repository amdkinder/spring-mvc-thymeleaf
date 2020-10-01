package uz.kuchkarov.springmvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kuchkarov.springmvc.model.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
