package com.textbond.targetapp.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
//The only work of Controller is accpet and send DTO and ask Servies to do rest
@RestController
/*
SO RestController is actually the combination of two annotaion which is
@Controller-> This class handles HTTP requests, and its return values are interpreted as
VIEW NAMES (HTML pages) unless told otherwise.
@ResponseBody->This class handles HTTP request,and its return values are interpreted as
JSON but does not reders pages
So what does @RestController do
This class handles HTTP requests AND always returns data (JSON/XML), never views.

@Controller → “Render pages”

@ResponseBody → “Send data”

@RestController → “API-only controller”

simple and sweet

Controller handles HTTP requests, and JSON is the format used to send and receive data in REST APIs.
 */
@RequestMapping("/images")
// its just to map to this class and use this functions
@CrossOrigin("*")

public class ImageController {

    private static final String IMAGE_DIR = "uploads/products/";

    @GetMapping("/{fileName}")
    // when adding this means we get inputs and that brackets is the url address layout
    public ResponseEntity<Resource> getImage(@PathVariable String fileName)
            //the Pathvariable is used here to extrat the data from the url in this case the fileName
            throws MalformedURLException {

        /*
        ok so the get() methord returns an path object where the get
        gudes where the file location is actually is
        resolve is nothing but it addes a new folder or file to it
         */
        Path filePath = Paths.get(IMAGE_DIR).resolve(fileName);

        // 2️⃣ Create resource from file
        Resource resource = new UrlResource(filePath.toUri());

        // 3️⃣ Return image if exists
        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)//this is the head ok
                    .body(resource);
            /*
            ok this say if the file exits and is readable then say the browser which type its
            and send the image that it
             */
        }

        return ResponseEntity.notFound().build();
        // this say the file does not exit or image and we are not sending u the respones
    }
}
