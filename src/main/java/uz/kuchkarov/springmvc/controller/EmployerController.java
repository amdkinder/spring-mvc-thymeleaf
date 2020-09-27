package uz.kuchkarov.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.kuchkarov.springmvc.model.Employer;
import uz.kuchkarov.springmvc.service.EmployerService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    private final EmployerService employerService;
    private final Logger logger =  LoggerFactory.getLogger(EmployerController.class);
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping
    public String getAll(Model model, HttpServletRequest request){
        model.addAttribute("employers", employerService.getAll());
        return "employer/employer";
    }

    @GetMapping("/new")
    public String pushCreateEmployer(Model model){
        model.addAttribute("employer", new Employer());
        return "employer/employer_update";
    }

    @GetMapping("/{id}/edit")
    public String pushEditEmployer(Model model, @PathVariable Long id){
        model.addAttribute("employer", employerService.getOne(id));
        return "employer/employer_update";
    }

    @GetMapping("/{id}")
    public String pushToView(Model model, @PathVariable Long id) {
        model.addAttribute("employer", employerService.getOne(id));
        return "employer/employer_view";
    }

    @PostMapping
    public String saveEmployer(@ModelAttribute("employer") Employer employer) {
        if (employer.getId() == null) {
            employerService.save(employer);
        } else {
            employerService.edit(employer.getId(), employer);
        }
        return "redirect:/employer";
    }
}
