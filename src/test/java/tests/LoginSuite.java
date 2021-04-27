package tests;


import org.junit.Test;

public class LoginSuite extends BaseTest {
    @Test
    public void happyPathLogin(){
        //metodo1();
        ingresarPagina("http:vamonos-finance.herokuapp.com");
        //metodo2();
        clicLogin("israel.bibiano","test1234");
        validacionLogin();
    }

    @Test
    public void invalidLogin(){

    }
    @Test
    public void emptyFieldLogin(){

    }
}
