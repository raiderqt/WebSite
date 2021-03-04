package com.erzhanium.WebSite.Controllers;

import com.erzhanium.WebSite.models.Food;
import com.erzhanium.WebSite.repo.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title");
        return "redirect:/food";
    }



}