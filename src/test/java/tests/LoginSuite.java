package tests;


import org.junit.Test;

public class LoginSuite extends BaseTest {
    @Test
    public void happyPathLogin() throws Exception{
        ingresarPagina("http:vamonos-finance.herokuapp.com");
        Login("israel.bibiano","prueba123");
        despuesLogin();
    }
    @Test
    public void invalidLogin() throws Exception{
        ingresarPagina("http:vamonos-finance.herokuapp.com");
        Login("israel.bibiano","prueba1234");
        loginFallido();
    }
    @Test
    public void emptyFieldLogin() throws Exception{
        ingresarPagina("http:vamonos-finance.herokuapp.com");
        Login("", "");
        loginVacio();
    }
}
