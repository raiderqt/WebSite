package com.WebSite.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "map_food_image", schema = "public", uniqueConstraints = @UniqueConstraint(name = "food_main_unique", columnNames = {"food_id", "main"}))
public class MapFoodImage
{

	@EmbeddedId
	private Key key;

	@Column(name = "main", nullable = false)
	private boolean main;

	@Embeddable
	public static class Key implements Serializable
	{
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "image_id", nullable = false, foreignKey = @ForeignKey(name = "FK_IMAGE_ID"))
		private Image image;

		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "food_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FOOD_ID"))
		private Food food;

		@Override
		public boolean equals(Object o)
		{
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Key key = (Key) o;
			return image.equals(key.image) && food.equals(key.food);
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(image, food);
		}

		public Image getImage()
		{
			return image;
		}

		public void setImage(Image image)
		{
			this.image = image;
		}

		public Food getFood()
		{
			return food;
		}

		public void setFood(Food food)
		{
			this.food = food;
		}
	}

	public MapFoodImage()
	{
	}

	public MapFoodImage(Food food, Image image, boolean main)
	{
		this.key = new Key();
		this.key.food = food;
		this.key.image = image;
		this.main = main;
	}

	public Key getKey()
	{
		return key;
	}

	public void setKey(Key key)
	{
		this.key = key;
	}

	public boolean isMain()
	{
		return main;
	}

	public void setMain(boolean main)
	{
		this.main = main;
	}


}

