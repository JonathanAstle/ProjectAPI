package com.qa.controllers;

import com.qa.models.Image;
import com.qa.repository.ImageRepository;
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
public class ImageControllerTest {

    @InjectMocks
    private ImageController imageController;

    @Mock
    private ImageRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testListAllImages(){
        List<Image> imagesList = new ArrayList<>();
        Image image = new Image();
        image.setName("image name");
        image.setImg1("image location 1");
        //...
        imagesList.add(image);

        when(repository.findAll()).thenReturn(imagesList);

        assertEquals(imageController.listAllImages().get(0).getName(), "image name");
    }

    @Test
    public void testGetImage() {
        Image image = new Image();
        image.setName("image name");
        image.setImg1("image location 1");
        //...
        when(repository.findOne(anyLong())).thenReturn(image);

        assertEquals(imageController.getImage(anyLong()).getName(), "image name");

    }

    @Test
    public void testAddImage() {
        Image image = new Image();
        image.setName("image name");
        image.setImg1("image location 1");
        //...
        when(repository.saveAndFlush(image)).thenReturn(image);

        assertEquals(imageController.addImage(image).getName(), "image name");
    }

    @Test
    public void testDeleteImage() {
        Image image = new Image();
        image.setName("image name");
        image.setImg1("image location 1");
        //...
        when(repository.findOne(anyLong())).thenReturn(image);

        assertEquals(imageController.deleteImage(anyLong()).getName(), "image name");
    }

}