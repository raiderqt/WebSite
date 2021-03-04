package com.WebSite.Controllers;

import com.WebSite.repo.MapFoodImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
