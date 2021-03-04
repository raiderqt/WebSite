package com.erzhanium.WebSite.repo;

import com.erzhanium.WebSite.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food,Long>   {
}

