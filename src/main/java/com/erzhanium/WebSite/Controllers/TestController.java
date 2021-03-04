package com.erzhanium.WebSite.Controllers;

import com.erzhanium.WebSite.models.Food;
import com.erzhanium.WebSite.models.MapFoodImage;
import com.erzhanium.WebSite.repo.MapFoodImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {

    @Autowired
    private MapFoodImageRepository mapFoodImageRepository;

/*    @GetMapping("/databasetest")
    public String testbase(Model model) {

        return "Test/testDataBase";
    }

    @PostMapping("/databasetest")
    public String test23base(@RequestParam Long foodid, Model model) {
        MapFoodImage mapFoodImage = new MapFoodImage(foodid);
            mapFoodImageRepository.save(mapFoodImage);
        return "Test/testDataBase";
    }*/



}
