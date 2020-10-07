package uz.kuchkarov.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.kuchkarov.springmvc.exception.NotFoundException;
import uz.kuchkarov.springmvc.model.Education;
import uz.kuchkarov.springmvc.model.Employer;
import uz.kuchkarov.springmvc.repo.EmployerRepository;
import uz.kuchkarov.springmvc.service.EducationService;

@Controller
@RequestMapping("/education")
public class EducationController {

    private final EducationService educationService;
    private final EmployerRepository employerRepository;

    public EducationController(EducationService educationService, EmployerRepository employerRepository) {
        this.educationService = educationService;
        this.employerRepository = employerRepository;
    }

    @GetMapping("/{id}/new")
    public String pushCreateEducation(@PathVariable Long id, Model model) {
            model.addAttribute("education", new Education());
            model.addAttribute("action", String.format("/education/%s", id));
            return "education/education_update";

    }

    @PostMapping("/{id}")
    public String save(@PathVariable Long id, Education education, Model model) {
        Employer employer = employerRepository.findById(id).orElseThrow(NotFoundException::new);
        education.setEmployer(employer);
        educationService.save(education);
        model.addAttribute("employer", employer);
        model.addAttribute("educations", educationService.getByEmployer(employer));
        return "employer/employer_view";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Education education, Model model) {
        Education result = educationService.edit(id, education);
        model.addAttribute("employer", result.getEmployer());
        model.addAttribute("educations", educationService.getByEmployer(result.getEmployer()));
        return "employer/employer_view";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model){
        Employer employer = educationService.getOne(id).getEmployer();
        model.addAttribute("employer", employer);
        model.addAttribute("educations", educationService.getByEmployer(employer));
        educationService.delete(id);
        return "employer/employer_view";
    }
}
