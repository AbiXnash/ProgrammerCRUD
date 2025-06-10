package main;

import main.repo.ProgrammerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ProgrammerController {
    @Autowired ProgrammerRepo repo;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/addProgrammer")
    public ModelAndView addProgrammer(final Programmer programmer) {
        final ModelAndView mv = new ModelAndView("home");
        System.out.println(programmer);
        repo.save(programmer);
        mv.addObject("addMsg", programmer.getName() + " is added successfully");
        return mv;
    }

    @GetMapping("getProgrammer")
    public ModelAndView getProgrammer(@RequestParam final int id) {
        final ModelAndView mv = new ModelAndView("home");
        final Programmer programmer = repo.findById(id).orElse(null);

        if (programmer != null) {
            System.out.println(programmer);
            // System.out.println(repo.findByName("ABX"));
            mv.setViewName("home");
            mv.addObject("searchMsg", programmer.getName());
            return mv;
        } else {
            mv.setViewName("home");
            mv.addObject("searchMsg", "Programmer not found");
            return mv;
        }
    }

    @PostMapping("/deleteProgrammer")
    public ModelAndView deleteProgrammer(@RequestParam final int id) {
        final ModelAndView mv = new ModelAndView("home");
        final Programmer programmer = repo.findById(id).orElse(null);

        if (programmer != null) {
            repo.deleteById(id);
            final String msg = "Programmer " + programmer.getName() + " is removed!!";
            mv.addObject("deleteMsg", msg);
            System.out.println(msg);
        } else {
            final String msg = "Programmer not found";
            mv.addObject("deleteMsg", msg);
            System.out.println(msg);
        }

        return mv;
    }

    @PostMapping("/updateProgrammer")
    public ModelAndView updateProgrammer(@RequestParam final int id) {
        final ModelAndView mv = new ModelAndView("home");
        final Programmer programmer = repo.findById(id).orElse(null);

        if (programmer != null) {
            mv.setViewName("edit");
            mv.addObject("programmer", programmer);
        } else {
            mv.addObject("updateMsg", "Programmer not exist with id: " + id);
        }
        return mv;
    }

    @PostMapping("/editProgrammer")
    public ModelAndView editProgrammer(
            @RequestParam final int id, @RequestParam final String name) {
        final ModelAndView mv = new ModelAndView("home");
        final Programmer programmer = repo.findById(id).orElse(null);

        if (programmer != null) {
            programmer.setName(name);
            repo.save(programmer);
            mv.addObject("updateMsg", "updated: " + programmer);
        } else {
            mv.addObject("updateMsg", "Programmer not exist");
        }

        return mv;
    }

    @GetMapping("/programmers")
    @ResponseBody
    public List<Programmer> allProgrammers() {
        return repo.findAll();
    }

    @GetMapping("/programmer/{id}")
    @ResponseBody
    public Optional<Programmer> programmer(@PathVariable("id") int id) {
        return repo.findById(id);
    }
}
