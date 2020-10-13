package uz.kuchkarov.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.kuchkarov.springmvc.model.Employer;
import uz.kuchkarov.springmvc.service.EducationService;
import uz.kuchkarov.springmvc.service.EmployerService;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    private final EmployerService employerService;
    private final EducationService educationService;

    private final Logger logger = LoggerFactory.getLogger(EmployerController.class);

    public EmployerController(EmployerService employerService, EducationService educationService) {
        this.employerService = employerService;
        this.educationService = educationService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("employers", employerService.getAll());
        return "employer/employer";
    }

    @GetMapping("/new")
    public String pushCreateEmployer(Model model) {
        model.addAttribute("employer", new Employer());
        model.addAttribute("action", "/employer");
        return "employer/employer_update";
    }

    @GetMapping("/{id}/edit")
    public String pushEditEmployer(Model model, @PathVariable Long id) {
        Employer employer = employerService.getOne(id);
        model.addAttribute("employer", employer);
        model.addAttribute("action", String.format("/employer/%s/edit", employer.getId()));
        return "employer/employer_update";
    }

    @GetMapping("/{id}")
    public String pushToView(Model model, @PathVariable Long id) {
        Employer employer = employerService.getOne(id);
        model.addAttribute("employer", employer);
        model.addAttribute("educations", educationService.getByEmployer(employer));
        educationService.getByEmployer(employer).forEach(education -> logger.info(education.toString()));
        return "employer/employer_view";
    }

    @PostMapping
    public String save(@ModelAttribute("employer") Employer employer, Model model) {
        Employer result = employerService.save(employer);
        logger.info(employer.toString());
        model.addAttribute("employer", result);
        model.addAttribute("educations", educationService.getByEmployer(employer));
        return "employer/employer_view";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute("employer") Employer employer, @PathVariable Long id, Model model) {
        Employer result = employerService.edit(id, employer);
        logger.info(employer.toString());
        model.addAttribute("employer", result);
        model.addAttribute("educations", educationService.getByEmployer(employer));
        return "employer/employer_view";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        employerService.delete(id);
        return "redirect:/employer";
    }
}
