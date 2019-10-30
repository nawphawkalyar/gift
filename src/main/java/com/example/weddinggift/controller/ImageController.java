package com.example.weddinggift.controller;

import com.example.weddinggift.model.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/images")
@CrossOrigin("*")
public class ImageController {

    @Value("http://localhost:80/images/")
    private String baseUrl;

    @Value("C:/nginx-1.16.1/html/images/")
    private String location;

    @PostMapping
    public ResponseEntity<Image> upload(@RequestParam MultipartFile file) throws IOException {
        String name = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"))
                .concat(file.getOriginalFilename());
        String imagePath = baseUrl.concat(name);

        file.transferTo(Paths.get(location).resolve(name));

         Image image=new Image(name,imagePath);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(image);
    }

}
