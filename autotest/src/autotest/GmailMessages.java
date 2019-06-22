/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autotest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Estifanos
 */
public class GmailMessages {
    
    public static void main(String[] args) throws InterruptedException,IOException {
    
    System.setProperty("webdriver.gecko.driver","C:\\Gecko\\geckodriver.exe");
        
    WebDriver driver = new FirefoxDriver();

    driver.manage().window().maximize();

    String url = "https://accounts.google.com/signin";

    driver.get(url);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

    WebElement email = driver.findElement(By.xpath("//input[@id='identifierId']"));

    email.sendKeys("Bruktawitteklay23@gmail.com");

    driver.findElement(By.id("identifierNext")).click();

    WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

    WebDriverWait wait = new WebDriverWait(driver, 20);

    wait.until(ExpectedConditions.elementToBeClickable(password));

    password.sendKeys("Godislove@23");

    driver.findElement(By.id("passwordNext")).click();
    
    List<WebElement> unreademail = driver.findElements(By.xpath("//*[@class='zA zE']"));
    
    
    
    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Estifanos\\Desktop\\UnreadEmail.txt"));
    writer.write("Number of unread mails:"+ unreademail.size());
    for(int i=0;i<unreademail.size();i++){
        writer.append(unreademail.get(i).getText());
    }
    writer.close();
    }
    }

