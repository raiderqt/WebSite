package com.erzhanium.WebSite.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.nio.file.Path;
import java.util.List;


@Entity

public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*@GenericGenerator(name = "uuid", strategy = "uuid2")*/
    private Long id;

    private byte[] imageDB;

    /*@OneToMany(mappedBy = "image")
    private List<Image> imageList;*/









    public Image() {
    }

    public Image(byte[] imageDB) {
        this.imageDB = imageDB;
    }



    public Image(Long id) {
        this.id = id;
    }

    public byte[] getImageDB() {
        return imageDB;
    }

    public void setImageDB(byte[] imageDB) {
        this.imageDB = imageDB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
