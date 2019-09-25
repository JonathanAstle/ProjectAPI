package com.qa.controllers;

import com.qa.models.Rating;
import com.qa.repository.RatingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RatingControllerTest {

    @InjectMocks
    private RatingController ratingController;

    @Mock
    private RatingRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testListAllRatings(){
        List<Rating> ratingsList = new ArrayList<>();
        Rating rating = new Rating();
        rating.setName("rating name");
        rating.setRating(5);
        rating.setComment("rating comment");
        ratingsList.add(rating);

        when(repository.findAll()).thenReturn(ratingsList);

        assertEquals(ratingController.listAllRatings().get(0).getName(), "rating name");
    }

    @Test
    public void testGetRating() {
        Rating rating = new Rating();
        rating.setName("rating name");
        rating.setRating(5);
        rating.setComment("rating comment");

        when(repository.findOne(anyLong())).thenReturn(rating);

        assertEquals(ratingController.getRating(anyLong()).getName(), "rating name");

    }

    @Test
    public void testAddRating() {
        Rating rating = new Rating();
        rating.setName("rating name");
        rating.setRating(5);
        rating.setComment("rating comment");

        when(repository.saveAndFlush(rating)).thenReturn(rating);

        assertEquals(ratingController.addRating(rating).getName(), "rating name");
    }

    @Test
    public void testDeleteRating() {
        Rating rating = new Rating();
        rating.setName("rating name");
        rating.setRating(5);
        rating.setComment("rating comment");

        when(repository.findOne(anyLong())).thenReturn(rating);

        assertEquals(ratingController.deleteRating(anyLong()).getName(), "rating name");
    }

    @Test
    public void testUpdateRating() {
        Rating rating = new Rating();
        rating.setName("rating name");
        rating.setRating(5);
        rating.setComment("rating comment");

        when(repository.findOne(anyLong())).thenReturn(rating);

        assertEquals(ratingController.updateRating(rating, anyLong()).getName(), "rating name");
    }

}