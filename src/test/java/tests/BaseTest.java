package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;



    @Before
    public void before() {
        driver = new ChromeDriver();
    }

    @After
    public void after() {
    //driver.quit();
    }

    protected void ingresarPagina(String url) {
        driver.get(url);
    }
    protected void clicLogin(String user, String password){
        try{
            WebElement CampoUsername = driver.findElement(By.cssSelector("[name='username']")),
                    campoPassword = driver.findElement(By.cssSelector("[name='password']"));
            CampoUsername.sendKeys(user);
            campoPassword.sendKeys(password);
            WebDriverWait explicitWait = new WebDriverWait(driver, 10);
            WebElement botonLogin = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn")));
            botonLogin.click();
        }catch(NoSuchElementException e){
            System.out.println(e + " No fue posible localizar algún elemento");
        }
    }
    protected void validacionLogin(){
        try{
            }catch (NoSuchElementException e){

        }
    }




}
