package com.WebSite.models;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "food", schema = "public")
public class Food
{
	//todo: каскад делит связей
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	public BigDecimal price;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String fulltext)
	{
		this.description = fulltext;
	}

	public Food()
	{
	}

	public Food(String name, BigDecimal price, String description)
	{
		this.price = price;
		this.name = name;
		this.description = description;
	}
}
