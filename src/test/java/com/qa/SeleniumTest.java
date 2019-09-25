package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void moveBetweenPagesTest() throws InterruptedException {
        driver.get("http://34.89.9.121/index.html");
        Thread.sleep(800);

        WebElement slavDefenseButton = driver.findElement(By.id("Slav Defense Button"));

        slavDefenseButton.click();
        Thread.sleep(800);

        WebElement chessOpeningsButton = driver.findElement(By.id("Chess Openings Button"));

        chessOpeningsButton.click();
        Thread.sleep(800);

        WebElement kingsGambitButton = driver.findElement(By.id("King's Gambit Button"));

        kingsGambitButton.click();
        Thread.sleep(800);

        WebElement queensGambitButton = driver.findElement(By.id("Queen's Gambit Button"));

        queensGambitButton.click();
    }

    @Test
    public void changeImageButtonsTest() throws InterruptedException {
        driver.get("http://34.89.9.121/Queen's%20Gambit.html");
        Thread.sleep(800);

        WebElement forward = driver.findElement(By.id("forwardButton"));
        WebElement backward = driver.findElement(By.id("backButton"));
        WebElement reset = driver.findElement(By.id("resetButton"));
        WebElement board = driver.findElement(By.id("board"));

        assertTrue(board.getAttribute("src").equals("https://i.ibb.co/T4NhvTX/0.png"));
        backward.click();
        Thread.sleep(800);
        assertTrue(board.getAttribute("src").equals("https://i.ibb.co/T4NhvTX/0.png"));
        forward.click();
        Thread.sleep(800);
        assertTrue(board.getAttribute("src").equals("https://i.ibb.co/Nxxf0xd/1.png"));
        forward.click();
        Thread.sleep(200);
        forward.click();
        Thread.sleep(200);
        forward.click();
        Thread.sleep(200);
        assertTrue(board.getAttribute("src").equals("https://i.ibb.co/KDG2Gvk/3.png"));
        reset.click();
        Thread.sleep(800);
        assertTrue(board.getAttribute("src").equals("https://i.ibb.co/T4NhvTX/0.png"));
    }

    @Test
    public void setStarRatingTest() throws InterruptedException {
        driver.get("http://34.89.9.121/Queen's%20Gambit.html");
        Thread.sleep(800);

        WebElement star1 = driver.findElement(By.id("star1"));
        WebElement star2 = driver.findElement(By.id("star2"));
        WebElement star3 = driver.findElement(By.id("star3"));
        WebElement star4 = driver.findElement(By.id("star4"));
        WebElement star5 = driver.findElement(By.id("star5"));

        star3.click();
        Thread.sleep(800);

        assertTrue(star1.getAttribute("class").equals("fa fa-star checked"));
        assertTrue(star2.getAttribute("class").equals("fa fa-star checked"));
        assertTrue(star3.getAttribute("class").equals("fa fa-star checked"));
        assertTrue(star4.getAttribute("class").equals("fa fa-star"));
        assertTrue(star5.getAttribute("class").equals("fa fa-star"));

        driver.navigate().refresh();
        Thread.sleep(800);

        star1 = driver.findElement(By.id("star1"));
        star2 = driver.findElement(By.id("star2"));
        star3 = driver.findElement(By.id("star3"));
        star4 = driver.findElement(By.id("star4"));
        star5 = driver.findElement(By.id("star5"));

        assertTrue(star1.getAttribute("class").equals("fa fa-star checked"));
        assertTrue(star2.getAttribute("class").equals("fa fa-star checked"));
        assertTrue(star3.getAttribute("class").equals("fa fa-star checked"));
        assertTrue(star4.getAttribute("class").equals("fa fa-star"));
        assertTrue(star5.getAttribute("class").equals("fa fa-star"));
    }

    @Test
    public void setCommentTest() throws InterruptedException {
        driver.get("http://34.89.9.121/Queen's%20Gambit.html");
        Thread.sleep(800);

        WebElement commentBox = driver.findElement(By.id("commentBox"));
        WebElement submitComment = driver.findElement(By.id("submit button"));
        WebElement comment = driver.findElement(By.id("comments paragraph"));

        commentBox.sendKeys("I really like this opening because it is good!");
        submitComment.click();
        Thread.sleep(800);

        WebElement confirm = driver.findElement(By.id("yesButton"));
        confirm.click();
        Thread.sleep(800);

        assertTrue(comment.getText().equals("I really like this opening because it is good!"));

        driver.navigate().refresh();
        Thread.sleep(800);

        comment = driver.findElement(By.id("comments paragraph"));
        assertTrue(comment.getText().equals("I really like this opening because it is good!"));
    }

    @Test
    public void removeStarRatingTest() throws InterruptedException {
        driver.get("http://34.89.9.121/Queen's%20Gambit.html");
        Thread.sleep(800);

        WebElement removeRating = driver.findElement(By.id("removeRatingButton"));
        WebElement star1 = driver.findElement(By.id("star1"));
        WebElement star2 = driver.findElement(By.id("star2"));
        WebElement star3 = driver.findElement(By.id("star3"));
        WebElement star4 = driver.findElement(By.id("star4"));
        WebElement star5 = driver.findElement(By.id("star5"));

        removeRating.click();
        Thread.sleep(500);

        assertTrue(star1.getAttribute("class").equals("fa fa-star"));
        assertTrue(star2.getAttribute("class").equals("fa fa-star"));
        assertTrue(star3.getAttribute("class").equals("fa fa-star"));
        assertTrue(star4.getAttribute("class").equals("fa fa-star"));
        assertTrue(star5.getAttribute("class").equals("fa fa-star"));

        Thread.sleep(800);
    }

    @Test
    public void removeCommentsTest() throws InterruptedException {
        driver.get("http://34.89.9.121/Queen's%20Gambit.html");
        Thread.sleep(800);

        WebElement comment = driver.findElement(By.id("comments paragraph"));
        WebElement removeComment = driver.findElement(By.id("removeCommentsButton"));

        removeComment.click();
        Thread.sleep(500);

        WebElement confirm = driver.findElement(By.id("yesButton"));

        confirm.click();
        Thread.sleep(500);

        assertTrue(comment.getText().contains("There are currently no comments for this opening."));
    }
}
