package com.erzhanium.WebSite.models;

/*import org.hibernate.annotations.GenericGenerator;*/



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "map_food_image", schema = "public", catalog = "spring_web_site")
public class MapFoodImage {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*@GenericGenerator(name = "uuid", strategy = "uuid2")*/
    private Long id;


/*
    @Column(name = "food_id")
    private Long foodid;
*/


    @Column(name = "image_id")
    private Long imageid;





    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", foreignKey = @ForeignKey(name = "FK_FOOD_ID"))
    private Food food;



    /*@ManyToOne
    @JoinColumn(name = "image_id", foreignKey = @ForeignKey(name = "FK_IMAGE_ID"))
    private Image image;*/

    /*@ManyToOne ()
    @JoinColumn(name = "food_id", foreignKey = @ForeignKey(name = "FK_FOOD_ID"))
    private Food food;*/









/*    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

/*    public Long getFoodid() {
        return foodid;
    }

    public void setFoodid(Long foodid) {
        this.foodid = foodid;
    }*/

    public Long getImageid() {
        return imageid;
    }

    public void setImageid(Long imageid) {
        this.imageid = imageid;
    }

    public MapFoodImage() {
    }

 /*   public MapFoodImage(Long foodid) {
        this.foodid = foodid;
    }
*/
}

