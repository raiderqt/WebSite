package com.erzhanium.WebSite.repo;

import com.erzhanium.WebSite.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image,Long> {
}
