package org.example;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.Buffer;
import java.time.Duration;
import java.util.List;



public class Main {
    public static void main(String[] args){
        WebDriver driver= new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://parabank.parasoft.com/");
            WebElement userName= driver.findElement(By.name("username"));
            WebElement passWord= driver.findElement(By.name("password"));
            userName.sendKeys("john");
            passWord.sendKeys("demo");
            WebElement loginBut= driver.findElement(By.cssSelector("input[value='Log In']"));
            loginBut.click();
            wait.until(ExpectedConditions.urlContains("overview.htm"));
            System.out.println("Login Successful!");
            WebElement accountId= driver.findElement(By.id("accountTable"));
            System.out.println(accountId.isDisplayed());

            List<WebElement> tr= accountId.findElements(By.tagName("tr"));
            System.out.println("the size is :"+tr.size());
            for(int i=0;i<tr.size();i++) {
                System.out.println("row " + (i + 1) + tr.get(i).getText());}}
        finally {driver.quit();}
            {

        }





    }
}