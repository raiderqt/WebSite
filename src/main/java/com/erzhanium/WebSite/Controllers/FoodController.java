package com.erzhanium.WebSite.Controllers;


import com.erzhanium.WebSite.models.Food;
import com.erzhanium.WebSite.models.Image;
import com.erzhanium.WebSite.models.MapFoodImage;
import com.erzhanium.WebSite.repo.FoodRepository;
import com.erzhanium.WebSite.repo.ImageRepository;
import com.erzhanium.WebSite.repo.MapFoodImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
public class FoodController {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	@Autowired
	private ImageRepository imageRepository;



	@Autowired
	private FoodRepository foodRepository;


	@Autowired
	private MapFoodImageRepository mapFoodImageRepository;








	@RequestMapping("/food")
	public String foodImages( Model model){
		return "food-main";
	}

	@GetMapping("/food")
	public String foodMain( Model model) {
		Iterable<Food> foods = foodRepository.findAll();
		model.addAttribute("foods", foods);

		/*String	base64String = "";
		for(Image imageModel : imageRepository.findAll()){
			base64String = new String(Base64.getEncoder().encode(imageModel.getImageDB()));
		}
		String images = "data:image/jpg;base64," + base64String;
		model.addAttribute("images", images );*/
		/*imageRepository.findAll();*/

		/*List<Image> img = new ArrayList<>();
		List<String> imgs = new ArrayList<>();
		imageRepository.findAll().forEach(img::add);
 		System.out.println(img);
		System.out.println(foods);*/



		model.addAttribute("images","data:image/jpg;base64," + new String(Base64.getEncoder().encode(imageRepository.findAll().iterator().next().getImageDB())));
		/*model.addAttribute("images","data:image/jpg;base64," + new String(Base64.getEncoder().encode()));*/
		return "food-main";
	}
/*	@PostMapping("/food"){

	}*/


	@GetMapping("/food/add")
	public String foodAdd(Model model) {
		return "foodAdd";
	}

	@PostMapping("/food/add")
	public String foodPostAdd(@RequestParam String anons,String title, Model model, @RequestParam("files") MultipartFile[] files, byte[] imageDB ) {
		Food food = new Food(anons,title);
		foodRepository.save(food);

		Path onlyPath;
		byte[] fileBytes ;
		String base64String = "";
		Path fileNameAndPath = Paths.get(uploadDirectory, files[0].getOriginalFilename());



		try
		{
			onlyPath = Files.write(fileNameAndPath, files[0].getBytes());
			fileBytes = Files.readAllBytes(onlyPath);
			imageDB= fileBytes;
			Image image = new Image(imageDB);
			imageRepository.save(image);

			base64String = new String(Base64.getEncoder().encode(fileBytes));

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		model.addAttribute("imagePath", "data:image/jpg;base64," + base64String);
		return "foodAdd";
	}


	@GetMapping("/food/{id}")
	public String foodDetails(@PathVariable(value = "id") long id, Model model) {
		if (!foodRepository.existsById(id)) {
			return "redirect:/food";
		}
		Optional<Food> food = foodRepository.findById(id);
		ArrayList<Food> result = new ArrayList<>();
		food.ifPresent(result::add);
		model.addAttribute("food", result);
		return "food-details";
	}

	@GetMapping("/admin")
	public String admin(Model model) {
		Iterable<Food> foods = foodRepository.findAll();
		/*  foodRepository.deleteAll();*/
		model.addAttribute("foods", foods);

		System.out.println(mapFoodImageRepository.findAll());
		return "admin";
	}

	@GetMapping("/food/{id}/edit")
	public String foodEdit(@PathVariable(value = "id") long id, Model model) {
		if (!foodRepository.existsById(id)) {
			return "redirect:/food";
		}
		Optional<Food> food = foodRepository.findById(id);
		ArrayList<Food> result = new ArrayList<>();
		food.ifPresent(result::add);
		model.addAttribute("food", result);
		return "food-edit";
	}

	@PostMapping("/food/{id}/edit")
	public String foodPostUpdate(@PathVariable(value = "id") long id, @RequestParam String anons,String title, Model model) {
		Food food = foodRepository.findById(id).orElseThrow(IllegalStateException::new);
		food.setAnons(anons);
		food.setAnons(title);
		foodRepository.save(food);
		return "redirect:/admin";
	}
	@PostMapping("/food/{id}/remove")
	public String foodPostDelete(@PathVariable(value = "id") long id, Model model) {
		Food food = foodRepository.findById(id).orElseThrow(IllegalStateException::new);
		/*foodRepository.delete(food);*/
		foodRepository.deleteAll();
		imageRepository.deleteAll();
		return "redirect:/admin";
	}
	@GetMapping("/image")
	public String image(Model model){
		model.addAttribute("title");
		return "uploadForm";
	}

/*
	@GetMapping("/dbtest")
	public String dbtest(Model model){
		return "Test/testDataBase";
	}

	@PostMapping("/dbtest")
		public String dbtest (@RequestParam long foodid, Model model){

		MapFoodImage mapFoodImage = new MapFoodImage(foodid);
		mapFoodImageRepository.save(mapFoodImage);
		return "Test/testDataBase";
	}
*/





}