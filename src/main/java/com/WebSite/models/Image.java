package com.WebSite.models;

import javax.persistence.*;


@Entity
@Table(name = "image", schema = "public")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private byte[] imageDB;

    public Image() {}

    public Image(byte[] imageDB) {
        this.imageDB = imageDB;
    }

    public byte[] getImageDB() {
        return imageDB;
    }

    public void setImageDB(byte[] imageDB) {
        this.imageDB = imageDB;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
