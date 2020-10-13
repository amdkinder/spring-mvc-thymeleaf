package uz.kuchkarov.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.kuchkarov.springmvc.exception.NotFoundException;
import uz.kuchkarov.springmvc.model.Education;
import uz.kuchkarov.springmvc.model.Employer;
import uz.kuchkarov.springmvc.repo.EmployerRepository;
import uz.kuchkarov.springmvc.service.EducationService;

@Controller
@RequestMapping("/education")
public class EducationController {

    private final EducationService educationService;

    private final Logger logger = LoggerFactory.getLogger(EducationController.class);

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/{id}/new")
    public String pushCreateEducation(@PathVariable("id") Employer employer, Model model) {
        Education education = new Education();
        education.setEmployer(employer);
        logger.info(education.toString());
        model.addAttribute("education", education);
        model.addAttribute("action", "/education");
        return "education/education_update";

    }

    @PostMapping
    public String save(@ModelAttribute("education") Education education) {
        logger.info(education.toString());
        educationService.save(education);
        return "redirect:/employer/" + education.getEmployer().getId();
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Education education, Model model) {
        Education result = educationService.edit(id, education);
        return "redirect:/employer/" + result.getEmployer().getId();
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        Employer employer = educationService.getOne(id).getEmployer();
        educationService.delete(id);
        return "redirect:/employer/" + employer.getId();

    }
}
