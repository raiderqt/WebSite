package com.WebSite.Controllers.Cases;

import com.WebSite.models.Food;
import com.WebSite.models.Image;

import java.math.BigDecimal;
import java.util.Base64;
public class ProductThymeleaf
{
	private final int id;
	private final String name;
	private final BigDecimal price;
	private final String description;
	private final String imageBase64;

	public ProductThymeleaf(Food food, Image image)
	{
		this.id = food.getId();
		this.name = food.getName();
		this.price = food.getPrice();
		this.description = food.getDescription();
		this.imageBase64 = "data:image/jpg;base64," + new String(Base64.getEncoder().encode(image.getImageDB()));
	}

	public String getName()
	{
		return name;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public String getDescription()
	{
		return description;
	}

	public String getImageBase64()
	{
		return imageBase64;
	}

	public int getId()
	{
		return id;
	}
}
