package com.lithan.Mealsonwheelsbackend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lithan.Mealsonwheelsbackend.entity.Meal;
import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.repo.MealRepository;
import com.lithan.Mealsonwheelsbackend.repo.PartnerRepository;


@CrossOrigin(origins = {"http://localhost:5173"})
@RestController
@RequestMapping("/meal-api")
public class MealController {

   

	
    @Autowired
    private PartnerRepository partnerRepository;
	
	@Autowired
	MealRepository mealRepository;
	
	@PreAuthorize("hasAuthority('ROLE_MEMBER')")
	@GetMapping("/meals")
	public List<Meal> allMeals() {
		List<Meal> allMeals = mealRepository.findAll();
		return allMeals;
	}
    
    
    @PostMapping("/{partnerId}/add")
    public ResponseEntity<String> handleFileUpload(
    		@PathVariable Long partnerId,
    		@RequestParam("file") MultipartFile file,
    		@RequestParam("mealName") String mealName,
    		@RequestParam("mealDesc") String mealDesc,
    		HttpSession session) {
        try {
      
            // Get the original file name
            String fileName = file.getOriginalFilename();
            ;
            Meal meal = new Meal();
            meal.setMealName(mealName);
            meal.setMealPhoto(fileName);
            meal.setMealDesc(mealDesc);
            
            
            // Define the absolute path for storing uploaded files
            String uploadDirectory = "C:\\Users\\Kyaw San Mg\\Downloads\\Admin_login_Meals-on-wheels-backend\\Meals-on-wheels-backend\\src\\main\\resources\\static\\uploads\\images"; // Update this with your desired path

            // Create the directory if it doesn't exist
            File directory = new File(uploadDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
                System.out.println("a new directory is created");
            }

            // Upload the file to the specified directory
            String filePath = uploadDirectory + File.separator + fileName;
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath);
            Files.write(path, bytes);

            System.out.println("File successfully saved!");

            Optional<Partner> optionalPartner = partnerRepository.findById(partnerId);

            // Check if the partner exists
            if (optionalPartner.isPresent()) {
                Partner partner = optionalPartner.get();

                // Associate the meal with the partner
                meal.setPartner(partner);

                // Add the meal to the partner's list of provided meals
                partner.getProvidedMeals().add(meal);

                // Save the updated partner to the database
                partnerRepository.save(partner);

                // Save the meal to the database
                return ResponseEntity.ok("Meal is added");
            } else {
                throw new EntityNotFoundException("Partner not found with id: " + partnerId);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading file");
        }
    }
    
    
}

