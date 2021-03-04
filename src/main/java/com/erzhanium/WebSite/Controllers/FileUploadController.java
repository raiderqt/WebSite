package com.erzhanium.WebSite.Controllers;

import com.erzhanium.WebSite.models.Image;

import com.erzhanium.WebSite.repo.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;


@Controller
public class FileUploadController {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private ImageRepository imageRepository;


	@RequestMapping("/image")
	public String UploadPage(Model model)
	{

		return "uploadForm";
	}


	@RequestMapping("/upload")
	public String upload(Model model, @RequestParam("files") MultipartFile[] files, byte[] imageDB ) {

		Path onlyPath;
		byte[] fileBytes ;
		String base64String = "";
		Path fileNameAndPath = Paths.get(uploadDirectory, files[0].getOriginalFilename());
		if(!(files ==null)) {
			try {
				onlyPath = Files.write(fileNameAndPath, files[0].getBytes());
				fileBytes = Files.readAllBytes(onlyPath);
				imageDB = fileBytes;
				Image image = new Image(imageDB);
				imageRepository.save(image);

				base64String = new String(Base64.getEncoder().encode(fileBytes));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("msg", "Successfully uploaded files " + files[0].getOriginalFilename());
		model.addAttribute("imagePath", "data:image/jpg;base64," + base64String);
		return "uploadstatusview";
	}


/*    @GetMapping("/upload")
    public String image( Model model){
		String	base64String = "";

		for(Image imageModel : imageRepository.findAll()){
			base64String = new String(Base64.getEncoder().encode(imageModel.getImageDB()));
		}
		String imagePath = "data:image/jpg;base64," + base64String;

		model.addAttribute("msg", "test");
        model.addAttribute("imagePath", imagePath );
        return "uploadstatusview";
    }*/
}
