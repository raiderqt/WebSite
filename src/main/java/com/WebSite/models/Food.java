package com.WebSite.models;



import javax.persistence.*;

@Entity
@Table(name = "food", schema = "public")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title, anons, fulltext;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
