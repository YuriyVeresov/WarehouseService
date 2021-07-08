package ru.veresov.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.veresov.dao.AppleDAOImpl;
import ru.veresov.models.Apple;

import javax.validation.Valid;


@Controller
@RequestMapping("/warehouse")
public class ApplesController {

    AppleDAOImpl appleDAO;

    @Autowired
    public ApplesController(AppleDAOImpl appleDAO) {
        this.appleDAO = appleDAO;
    }

    @GetMapping()
    public String start(Model model) {
        model.addAttribute("appleList", appleDAO.start());
        return "apples/start";
    }

    @GetMapping("/apples/{id}")
    public String info(@PathVariable("id") int id, Model model) {
        model.addAttribute("apple", appleDAO.appleInfo(id));
        return "apples/info";
    }
    @GetMapping("/new")
    public String newApple(@ModelAttribute("newApple") Apple apple){
        return "apples/new";
    }
    @PostMapping()
    public String createApple(@ModelAttribute("newApple") Apple apple){
        appleDAO.addApple(apple);
        return "redirect:/warehouse";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("apple", appleDAO.appleInfo(id));
        return "apples/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("apple") Apple apple, @PathVariable("id") int id){
        appleDAO.updateApple(id, apple);
        return "redirect:/warehouse";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        appleDAO.deleteApple(id);
        return "redirect:/warehouse";
    }
}
