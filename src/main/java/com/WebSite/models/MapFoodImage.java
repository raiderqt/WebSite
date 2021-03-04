package com.WebSite.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "map_food_image", schema = "public", catalog = "spring_web_site")
public class MapFoodImage
{

	@EmbeddedId
	private Key key;

	@Embeddable
	public static class Key implements Serializable
	{
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "image_id", nullable = false, foreignKey = @ForeignKey(name = "FK_IMAGE_ID"))
		private Image image;

		public Image getImageId()
		{
			return image;
		}

		public void setImageId(Image image)
		{
			this.image = image;
		}

		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "food_id", nullable = false, foreignKey = @ForeignKey(name = "FK_FOOD_ID"))
		private Food food;

		public Food getFood()
		{
			return food;
		}

		public void setFood(Food food)
		{
			this.food = food;
		}

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
	}

	public MapFoodImage()
	{
	}

}

