package com.example.spring_thymeleaf.selenium.SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;


public class BaseTest {
    public WebDriver driver;
    private static String baseURL = "http://localhost:8080/laptimes";


    @BeforeAll
    public static void init(){
    }

    @BeforeEach
    public void setup() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        // options.addArguments("--headless");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @AfterEach
    public void quit() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}

