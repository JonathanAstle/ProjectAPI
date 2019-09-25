package com.qa.controllers;

import com.qa.models.Image;
import com.qa.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class ImageController {

    @Autowired
    private ImageRepository repository;

    @RequestMapping(value = "images", method = RequestMethod.GET)
    public List<Image> listAllImages() {
        return repository.findAll();
    }

    @RequestMapping(value = "images", method = RequestMethod.POST)
    public Image addImage(@RequestBody Image image){
        return repository.saveAndFlush(image);
    }

    @RequestMapping(value = "images/{id}", method = RequestMethod.GET)
    public Image getImage(@PathVariable Long id){
        return repository.findOne(id);
    }

    @RequestMapping(value = "images/{id}", method = RequestMethod.DELETE)
    public Image deleteImage(@PathVariable Long id){
        Image existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }
}