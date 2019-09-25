package com.qa.controllers;

import com.qa.models.Rating;
import com.qa.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class RatingController {

    @Autowired
    private RatingRepository repository;

    @RequestMapping(value = "ratings", method = RequestMethod.GET)
    public List<Rating> listAllRatings() {
        return repository.findAll();
    }

    @RequestMapping(value = "ratings", method = RequestMethod.POST)
    public Rating addRating(@RequestBody Rating rating){
        return repository.saveAndFlush(rating);
    }

    @RequestMapping(value = "ratings/{id}", method = RequestMethod.GET)
    public Rating getRating(@PathVariable Long id){
        return repository.findOne(id);
    }

    @RequestMapping(value = "ratings/{id}", method = RequestMethod.DELETE)
    public Rating deleteRating(@PathVariable Long id){
        Rating existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    @Transactional
    @RequestMapping(value = "ratings/{id}", method = RequestMethod.PUT)
    public Rating updateRating(@RequestBody Rating rating, @PathVariable Long id){
        Rating existing = repository.findOne(id);
        existing.setRating(rating);
        return existing;
    }
}