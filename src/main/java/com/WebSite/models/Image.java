package com.WebSite.models;

import javax.persistence.*;


@Entity

public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*@GenericGenerator(name = "uuid", strategy = "uuid2")*/
    private Integer id;

    private byte[] imageDB;

    /*@OneToMany(mappedBy = "image")
    private List<Image> imageList;*/

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
