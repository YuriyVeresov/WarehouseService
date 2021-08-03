package ru.veresov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.veresov.AppleNotFoundException;
import ru.veresov.services.AppleService;
import ru.veresov.models.Apple;

import java.util.List;

@Controller
@RequestMapping("/apples")
public class AppleController {
    AppleService appleService;

    @Autowired
    public AppleController(AppleService appleService) {
        this.appleService = appleService;
    }

    @GetMapping()
    public String showAllApples(Model model) {
        List<Apple> applesList = appleService.getAppleList();
        model.addAttribute("applesList", applesList);
        return "show";
    }

    @GetMapping("/new")
    public String showNewAppleForm(Model model) {
        model.addAttribute("apple", new Apple());
        model.addAttribute("pageTitle", "New apple");
        return "apple_form";
    }

    @PostMapping("/save")
    public String saveApple(Apple apple, RedirectAttributes attributes) {
        appleService.addApple(apple);
        attributes.addFlashAttribute("message", "The apple was saved successfully!");
        return "redirect:/apples";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {
        try {
            Apple apple = appleService.getApple(id);
            model.addAttribute("apple", apple);
            model.addAttribute("pageTitle", "Edit apple (id: " + id + ")");
            return "apple_form";
        } catch (AppleNotFoundException e) {
            attributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/apples";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        try {
            appleService.deleteApple(id);
            attributes.addFlashAttribute("message", "Apple successfully removed");
        } catch (AppleNotFoundException e) {
            attributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/apples";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {
        try {
            Apple apple = appleService.getApple(id);
            model.addAttribute("apple", apple);
            return "info";
        } catch (AppleNotFoundException e) {
            attributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/apples";
        }
    }
}
