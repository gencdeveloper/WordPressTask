package com.interview.tests.Task;

import com.interview.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WordpressTask {

    //I call from utilities package
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://wordpress.com/");
        Thread.sleep(2000);

        //locate planprice button
        WebElement planPrice = driver.findElement(By.xpath("//a[@class='x-nav-link x-link'] [1]"));
        planPrice.click();

        //i have to put wait because of my internet and computer
        Thread.sleep(1000);
        WebElement month = driver.findElement(By.xpath("//button[@option='month']"));
        month.click();

        Thread.sleep(1000);

        WebElement money = driver.findElement(By.xpath("//*[@id=\"lpc-plan-business\"]/div[1]/h5/amp-list/div/div/span[2]"));
        String ActualValue = money.getText();

        System.out.println("ActualValue = " + ActualValue);

        String ExpectedValue = "$33";
        //assertion for verify

        Assert.assertEquals(ActualValue,ExpectedValue);

    }


    @Test
    public void test2() throws InterruptedException {

        driver.get("https://wordpress.com/");
        Thread.sleep(5000);

        WebElement element = driver.findElement(By.cssSelector("#lpc-footer-nav > div > div.lpc-footer-nav-container > div:nth-child(4) > ul > li:nth-child(4) > a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        Thread.sleep(4000);

        WebElement popUp = driver.findElement(By.xpath("//*[@id=\"wpcom-home\"]/form/div[2]/a"));
        popUp.click();
        //Thread.sleep(2000); if you not work on your local you can put time

        WebElement elementTwo = driver.findElement(By.cssSelector("#lpc-footer-nav > div > div.lpc-footer-nav-container > div:nth-child(4) > ul > li:nth-child(4) > a"));
        actions.moveToElement(elementTwo).click().build().perform();

        //Thread.sleep(2000); if you not work on your local you can put time

        WebElement pointFive = driver.findElement(By.xpath("//h2[@id='fees-payments-renewal']"));
        System.out.println("pointFive.getText() = " + pointFive.getText());
        Assert.assertTrue(pointFive.isDisplayed());


    }

    @Test
    public void test3() throws InterruptedException {

        driver.get("https://wordpress.com/");
        //Thread.sleep(3000);

        //click products
        driver.findElement(By.xpath("//button[@role='menuitem'][1]")).click();
        Thread.sleep(1000);

        //click domains
        driver.findElement(By.xpath("//a[@href='https://wordpress.com/domains/'][1]")).click();
        Thread.sleep(5000);

        //Asserted
        Assert.assertTrue(driver.getCurrentUrl().contains("/domains/"));

        Thread.sleep(1000);
        //Type your text
        driver.findElement(By.xpath("//input[@placeholder='Find your domain']")).sendKeys("protestsolutions.net");

        //click search button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000);
        //Verified
        String actualContent = driver.findElement(By.xpath("//span[@class='notice__text']")).getText();
        String expectedContent ="protestsolutions.net is already registered. Please try another search.";

        //Asserted
        Assert.assertTrue(actualContent.contains(expectedContent));



    }




}
