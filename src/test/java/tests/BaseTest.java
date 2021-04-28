package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    protected WebElement linkRegistro;
    protected  WebElement nombre, apellido, usuario, correo, contrasena,
            repiteContrasena, telefono, nacimiento, numTarjeta, expiracion,
            cvv, botonRegistro;
    protected WebElement botonLogin;
    protected WebElement imageUsuarioEnUso;
    protected WebElement contrasenaDiferente;





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

    protected void obtenerCamposLlenado(){
        try {
            nombre = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='first_name']")));
            apellido = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='last_name']")));
            usuario = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='username']")));
            correo = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='email']")));
            contrasena = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='password']")));
            repiteContrasena = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='repeat_password']")));
            telefono = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='phone']")));
            nacimiento = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='birthdate']")));
            numTarjeta = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='cc']")));
            expiracion = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='expiration']")));
            cvv = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='cvv']")));
            botonRegistro = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn")));

            System.out.println("Los elementos son visibles");
        }catch (TimeoutException e){
            System.out.println("Los elementos no se muestran bien, revisa el proyecto");
        }
    }

    public void llenarInformacion(String fname, String lname, String username, String email, String password, String repeatPassword, String phone, String birthday, String cCard, String expDate, String ccvCard){
        try{
            nombre.sendKeys(fname);
            apellido.sendKeys(lname);
            usuario.sendKeys(username);
            correo.sendKeys(email);
            contrasena.sendKeys(password);
            repiteContrasena.sendKeys(repeatPassword);
            telefono.sendKeys(phone);
            nacimiento.sendKeys(birthday);
            numTarjeta.sendKeys(cCard);
            expiracion.sendKeys(expDate);
            cvv.sendKeys(ccvCard);
            botonRegistro.click();
        }catch (Exception e){
            System.out.println("No se pudo registrar al usuario");
        }
    }

    protected void clicRegister() throws Exception {
        explicitWait = new WebDriverWait(driver,5);
        try {
            linkRegistro = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/register']")));
            if(linkRegistro.isDisplayed()){
                linkRegistro.click();
            }else{
                throw new Exception("Link de registro no mostrado");
            }
        }catch (TimeoutException e){
            System.out.println("No fue posible dar clic al enlace");
        }
    }

    protected void Login(String username, String password) throws Exception{
        explicitWait = new WebDriverWait(driver,10);
        try{
            usuario = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='username']")));
            contrasena = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='password']")));
            usuario.sendKeys(username);
            contrasena.sendKeys(password);

            botonLogin = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn")));
            if(botonLogin.isDisplayed()){

                botonLogin.click();
                System.out.println("El inicio de sesión fue correcto");
            }else{
             throw new Exception("El inicio de sesión no se pudo completar, revisa la prueba");
            }
        }catch(NoSuchElementException e){
            System.out.println(e + " No fue posible localizar algún elemento");
        }
    }

    protected void mensajeUsuarioEnUso(){
        try{
            imageUsuarioEnUso = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(imageUsuarioEnUso,"src","already-taken"));
            System.out.println("La imagen de usuario en uso es visible");
        }catch (TimeoutException e){
            System.out.println("La imagen de usuario en uso no se visualiza");
        }
    }

    protected void mensajeContrasenaDiferente(){
        try{
            contrasenaDiferente = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.border")));
            explicitWait.until(ExpectedConditions.attributeContains(contrasenaDiferente,"src","do-not-match"));
            System.out.println("La imagen de contraseña diferentes es visible");
        }catch (TimeoutException e){
            System.out.println("La imagen de contraseña diferentes NO es visible");
        }
    }
}
