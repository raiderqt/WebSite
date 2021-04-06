package com.WebSite.repo;

import com.WebSite.models.Food;
import com.WebSite.models.MapFoodImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapFoodImageRepository extends CrudRepository<MapFoodImage, MapFoodImage.Key>
{
	MapFoodImage findFirstByKey_FoodAndMainTrue(Food food);
	MapFoodImage findAllByKey_Food(Food food);
}

