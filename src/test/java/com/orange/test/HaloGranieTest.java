package com.orange.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HaloGranieTest {

    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "src/test/driver/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://halogranie.orange.pl/");
    }

    //Musiałam opóźnić, bo tak powoli otwierała mi się strona, że nie zdążyło wyszukać elementów, a już kończyło test

    @Test
    public void checkIfAnElementsExistsTest() {
        WebDriverWait some_element = new WebDriverWait(driver,60);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div[1]/main/div/div[1]/www-side-panel/div/div/www-categories-list/div/ul/li[5]/a"))).click();
        boolean firstpage = driver.findElements(By.xpath("//*[@id='router-outlet-parent']/www-category-page/section/div[1]/div[1]/www-set-tile[1]")).size() != 0;
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"router-outlet-parent\"]/www-category-page/section/div[1]/div[2]/www-pagination/nav/button[2]"))).click();
        boolean secondpage = driver.findElements(By.xpath("//*[@id=\"router-outlet-parent\"]/www-category-page/section/div[1]/div[1]/www-set-tile[1]/a")).size() != 0;
    }

    @Test
    public void buyTest(){
        WebDriverWait some_element = new WebDriverWait(driver,60);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div[1]/main/div/div[1]/www-side-panel/div/div/www-categories-list/div/ul/li[4]/a"))).click();
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"router-outlet-parent\"]/www-category-page/section/div[1]/div[1]/www-set-tile[1]/a/div[2]/www-button/button"))).click();
        boolean element = driver.findElements(By.xpath("//*[@id=\"router-outlet-parent\"]/www-set-page/div[1]/div[2]/div[2]/div[1]")).size() != 0;
    }

    @Test
    public void checkRegulationsTest(){
        WebDriverWait some_element = new WebDriverWait(driver,60);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div[1]/main/div/div[1]/www-side-panel/div/div/p/a"))).click();
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"router-outlet-parent\"]/www-regulations/div/div/h3[1]"))).click();
        var regulations = driver.findElement(By.xpath("//*[text() ='Regulamin Halo Granie 2019']"));
        Assert.assertNull("There are no such regulations", regulations);


    }

    @After
    public void tearDown() throws Exception {

        driver.quit();
    }
}


