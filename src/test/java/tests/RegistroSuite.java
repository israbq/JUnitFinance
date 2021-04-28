package tests;

import org.junit.Test;

public class RegistroSuite extends BaseTest{
    @Test
    public void registroExitoso() throws Exception {
        ingresarPagina("http:vamonos-finance.herokuapp.com");
        clicRegister();
        obtenerCamposLlenado();
        llenarInformacion("Israel", "Bibiano", "israel.bibiano2", "israel@yopmail.com", "prueba123",
                "prueba123","5582159913", "12/12/2020","4152415241524152", "12/12", "012");
        Login("israel.bibiano","prueba123");
    }
    @Test
    public void usuarioRegistrado() throws Exception {
        ingresarPagina("http:vamonos-finance.herokuapp.com");
        clicRegister();
        obtenerCamposLlenado();
        llenarInformacion("Israel", "Bibiano", "israel.bibiano", "israel@yopmail.com", "prueba123",
                "prueba123","5582159913", "12/12/2020","4152415241524152", "12/12", "012");
        mensajeUsuarioEnUso();
    }
    @Test
    public void contrasenaDiferente() throws Exception {
        ingresarPagina("http:vamonos-finance.herokuapp.com");
        clicRegister();
        obtenerCamposLlenado();
        llenarInformacion("Israel", "Bibiano", "israel.bibiano", "israel@yopmail.com", "prueba123",
                "prueba1234","5582159913", "12/12/2020","4152415241524152", "12/12", "012");
        mensajeContrasenaDiferente();
    }
}
