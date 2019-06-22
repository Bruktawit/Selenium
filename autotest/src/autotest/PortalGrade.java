/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autotest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Estifanos
 */
public class PortalGrade {
    public static void main(String[] args) throws IOException {
        
        System.setProperty("webdriver.gecko.driver","C:\\Gecko\\geckodriver.exe");
        
        WebDriver driver;       
        
        driver= new FirefoxDriver();
        
        String appUrl="https://portal.aait.edu.et/";
        driver.get(appUrl);
        
        
        driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys("ATR/2447/09");
        
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("2323");
        
        driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button")).click();
        
        driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");
        
        String grade=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/table")).getText();
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Estifanos\\Desktop\\GradeReport.txt"));
        writer.write(grade);
     
        writer.close();
        
    }
}
