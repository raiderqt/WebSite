package com.erzhanium.WebSite.models;



import javax.persistence.*;

import java.util.List;

@Entity

public class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*@GenericGenerator(name = "uuid", strategy = "uuid2")*/
    private Long id;

    private String title, anons, fulltext;


    /*@OneToMany(mappedBy = "food")
    private List<Food> foodList;*/


  /*  public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }*/


    @OneToOne(mappedBy = "food")
    private MapFoodImage mapFoodImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    public Food() {
    }

    public Food( String anons,String title, String fulltext) {
        this.title = title;
        this.anons = anons;
        this.fulltext = fulltext;
    }



    public Food(String anons, String title) {

        this.anons = anons;
        this.title = title;

    }

}
