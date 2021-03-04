package com.WebSite.repo;

import com.WebSite.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food,Long>   {
}

