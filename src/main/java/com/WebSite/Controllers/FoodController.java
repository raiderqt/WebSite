package com.WebSite.Controllers;


import com.WebSite.Controllers.Cases.ProductThymeleaf;
import com.WebSite.models.Food;
import com.WebSite.models.Image;
import com.WebSite.models.MapFoodImage;
import com.WebSite.repo.FoodRepository;
import com.WebSite.repo.ImageRepository;
import com.WebSite.repo.MapFoodImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
public class FoodController
{
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private MapFoodImageRepository mapFoodImageRepository;

	public List<ProductThymeleaf> getAllProductThymeleaf()
	{
		Iterable<Food> goods = foodRepository.findAll();
		List<ProductThymeleaf> productThymeleafList = new ArrayList<>();
		for (Food food : goods)
		{
			ProductThymeleaf productThymeleaf = new ProductThymeleaf(food, mapFoodImageRepository.findFirstByKey_FoodAndMainTrue(food).getKey().getImage());
			productThymeleafList.add(productThymeleaf);
		}
		return productThymeleafList;
	}

	@PostMapping("/food")
	public String foodImages(@RequestParam String test, Model model)
	{
		return "food-main";
	}

	@GetMapping("/food")
	public String foodMain(Model model)
	{
		model.addAttribute("goods", getAllProductThymeleaf());
		return "food-main";
	}

	@GetMapping("/basket")
	public String basket(Model model)
	{

		return "basket";
	}
	@PostMapping(value = "/basket")
	public String basket(@RequestParam Integer id, Model model)
	{
		Optional<Food> item = foodRepository.findById(id);
		if(item.isPresent())
		{
			model.addAttribute("product_id", item.get().getId());
			model.addAttribute("product_name", item.get().getName());
			model.addAttribute("product_price", item.get().getPrice());
		}

		return "basket";
	}

	@GetMapping("/food/add")
	public String foodAdd(Model model)
	{


		return "foodAdd";
	}

	@PostMapping("/food/add")
	public String foodPostAdd(@RequestParam String description, BigDecimal price, String name, Model model, @RequestParam("files") MultipartFile[] files)
	{
		try
		{
			Food food = new Food(name, price, description);
			foodRepository.save(food);
			Image image = new Image(files[0].getBytes());
			imageRepository.save(image);
			MapFoodImage mapFoodImage = new MapFoodImage(food, image, true);
			mapFoodImageRepository.save(mapFoodImage);
			//base64String = new String(Base64.getEncoder().encode(image.getImageDB()));
			model.addAttribute("result", "?????????? ????????????????");
			model.addAttribute("resultColor", "green");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("result", "???????????? ????????????????????");
		}

		//model.addAttribute("imagePath", "data:image/jpg;base64," + base64String);
		return "foodAdd";
	}



	@GetMapping("/food/{id}")
	public String foodDetails(@PathVariable(value = "id") int id, Model model)
	{
		if (!foodRepository.existsById(id))
		{
			return "redirect:/food";
		}
		Optional<Food> food = foodRepository.findById(id);
		ArrayList<Food> result = new ArrayList<>();
		food.ifPresent(result::add);
		model.addAttribute("food", result);
		return "food-details";
	}

	@GetMapping("/admin")
	public String admin(Model model)
	{
		model.addAttribute("goods", getAllProductThymeleaf());
		return "admin";
	}

	@GetMapping("/food/{id}/edit")
	public String foodEdit(@PathVariable(value = "id") int id, Model model)
	{
		if (!foodRepository.existsById(id))
		{
			return "redirect:/food";
		}
		Optional<Food> food = foodRepository.findById(id);
		ArrayList<Food> result = new ArrayList<>();
		food.ifPresent(result::add);
		model.addAttribute("food", result);
		return "food-edit";
	}

	@PostMapping("/food/{id}/edit")
	public String foodPostUpdate(@PathVariable(value = "id") int id,
								 @RequestParam String name,
								 @RequestParam String description,
								 @RequestParam BigDecimal price,
								 Model model)
	{
		Food food = foodRepository.findById(id).orElseThrow(IllegalStateException::new);


		food.setName(name);
		food.setDescription(description);
		food.setPrice(price);
		/*image.setImageDB(imageDB);*/

		foodRepository.save(food);

		return "redirect:/admin";
	}
	@Transactional
	@PostMapping("/food/{id}/remove")
	public String foodPostDelete(@PathVariable(value = "id") int id, MapFoodImage.Key key, Model model)
	{
		Food food = foodRepository.findById(id).orElseThrow(IllegalStateException::new);


		mapFoodImageRepository.findAllByKey_Food(food);


		/*List<MapFoodImage> mapFoodImage =	mapFoodImageRepository.findAllByKey_Food(food);

		for (int i = 0; i < mapFoodImage.size() ; i++) {
			mapFoodImageRepository.delete(mapFoodImageRepository.findAllByKey_Food(food).get(i));
			foodRepository.deleteById(food.getId());

		}*/
		/*foodRepository.deleteById(id);*/







		return "redirect:/admin";
	}

	@GetMapping("/image")
	public String image(Model model)
	{
		model.addAttribute("title");
		return "uploadForm";
	}

	@GetMapping("/ordersTable")
	public String ordersTable(Model model){

		return "tableOrders";
	}

	@GetMapping("/ordersDetails")
	public String ordersDetails(Model model){

		return "ordersDetails";
	}



}