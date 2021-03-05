package com.WebSite.repo;

import com.WebSite.models.Food;
import com.WebSite.models.MapFoodImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapFoodImageRepository extends CrudRepository<MapFoodImage, MapFoodImage.Key>
{

	MapFoodImage findFirstByKey_FoodAndMainTrue(Food food);
}

